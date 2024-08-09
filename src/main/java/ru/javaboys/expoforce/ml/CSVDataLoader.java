package ru.javaboys.expoforce.ml;

import com.opencsv.CSVReader;
import weka.core.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVDataLoader {

    public Instances loadDataFromCSV(String csvFilePath) throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
        String[] header = csvReader.readNext(); // читаем заголовок CSV

        ArrayList<String> productTypes = new ArrayList<String>();
        productTypes.add("BANK_CARD");
        productTypes.add("CREDIT");
        productTypes.add("DEPOSIT");
        productTypes.add("MORTGAGE");
        productTypes.add("CAR");
        productTypes.add("CAR_RENTAL");
        productTypes.add("CAR_SERVICE");
        productTypes.add("INSURANCE");
        productTypes.add("LEGAL_SERVICE");
        productTypes.add("BOOKING");
        productTypes.add("BANQUETS");


        // Создаем атрибуты на основе заголовка CSV
        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("age"));
        attributes.add(new Attribute("incomeAmount"));
        attributes.add(new Attribute("married", List.of("True", "False"))); // Номинальный атрибут
        // Добавляем атрибут для предсказания - Product Suggestion
        Attribute productSuggestion = new Attribute("productSuggestion", productTypes);
        attributes.add(productSuggestion);

        // Создаем Instances
        Instances data = new Instances("ClientData", attributes, 0);

        String[] nextLine;
        while ((nextLine = csvReader.readNext()) != null) {
            DenseInstance instance = new DenseInstance(attributes.size());
            instance.setValue(attributes.get(0), Double.parseDouble(nextLine[0])); // age
            instance.setValue(attributes.get(1), Double.parseDouble(nextLine[1])); // incomeAmount
            instance.setValue(attributes.get(2), nextLine[2]); // married
            instance.setValue(attributes.get(3), nextLine[3]); // productSuggestion
            data.add(instance);
        }

        data.setClassIndex(data.numAttributes() - 1); // Устанавливаем классом последний атрибут
        csvReader.close();
        return data;
    }

    public Instances loadDataFromCSVWithoutProduct(String csvFilePath) throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
        String[] header = csvReader.readNext(); // читаем заголовок CSV

        // Создаем атрибуты на основе заголовка CSV
        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("age"));
        attributes.add(new Attribute("incomeAmount"));
        attributes.add(new Attribute("married", List.of("True", "False"))); // Номинальный атрибут


        // Создаем Instances
        Instances data = new Instances("ClientData", attributes, 0);

        String[] nextLine;
        while ((nextLine = csvReader.readNext()) != null) {
            DenseInstance instance = new DenseInstance(attributes.size());
            instance.setValue(attributes.get(0), Double.parseDouble(nextLine[0])); // age
            instance.setValue(attributes.get(1), Double.parseDouble(nextLine[1])); // incomeAmount
            instance.setValue(attributes.get(2), nextLine[2]); // married
            data.add(instance);
        }

        data.setClassIndex(data.numAttributes() - 1); // Устанавливаем классом последний атрибут
        csvReader.close();
        return data;
    }
}

