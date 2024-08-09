package ru.javaboys.expoforce.ml;

import ru.javaboys.expoforce.entity.ProductType;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            CSVDataLoader loader = new CSVDataLoader();
            Instances trainingData = loader.loadDataFromCSV("/Users/rustamgulyamov/PycharmProjects/tensorFlowDemo/clients_output.csv");

            ProductRecommender recommender = new ProductRecommender();
            recommender.trainModel(trainingData);

            Instances newClientsData = loader.loadDataFromCSVWithoutProduct("/Users/rustamgulyamov/PycharmProjects/tensorFlowDemo/clients_output_test.csv");

            // Создаем атрибуты для предсказанных продуктов
            List<String> productNames = ProductType.getNames();
            List<Attribute> predictedProductAttributes = new ArrayList<>();
            for (String productName : productNames) {
                predictedProductAttributes.add(new Attribute(productName));
            }
            Instances newClientsDataWithPredictions = new Instances(newClientsData);
            for (Attribute attr : predictedProductAttributes) {
                newClientsDataWithPredictions.insertAttributeAt(attr, newClientsDataWithPredictions.numAttributes());
            }

            // Выполняем предсказание и записываем результаты
            for (int i = 0; i < newClientsData.numInstances(); i++) {
                Instance clientInstance = newClientsData.instance(i);
                List<ProductType> predictedProducts = recommender.classifyInstance(clientInstance);

                // Устанавливаем предсказанные значения в новых атрибутах
                for (ProductType productType : ProductType.values()) {
                    int attrIndex = newClientsDataWithPredictions.attribute(productType.name()).index();
                    if (predictedProducts.contains(productType)) {
                        clientInstance.setValue(attrIndex, "TRUE");
                    } else {
                        clientInstance.setValue(attrIndex, "FALSE");
                    }
                }
            }

            // Сохраняем результаты в новый CSV файл
            saveInstancesToCSV(newClientsDataWithPredictions, "clients_with_predictions.csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveInstancesToCSV(Instances data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data.toString());
            writer.newLine();
            for (int i = 0; i < data.numInstances(); i++) {
                writer.write(data.instance(i).toString());
                writer.newLine();
            }
            System.out.println("Результаты сохранены в " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
