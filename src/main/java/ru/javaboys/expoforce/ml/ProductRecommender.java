package ru.javaboys.expoforce.ml;

import ru.javaboys.expoforce.entity.ProductType;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.Classifier;
import weka.classifiers.functions.MultilayerPerceptron;
import java.util.ArrayList;
import java.util.List;

public class ProductRecommender {
    private Classifier classifier;

    public void trainModel(Instances data) throws Exception {
        classifier = new MultilayerPerceptron(); // Пример классификатора
        classifier.buildClassifier(data);
    }

    public List<ProductType> classifyInstance(Instance instance) throws Exception {
        double[] distribution = classifier.distributionForInstance(instance);
        return getPredictedProducts(distribution);
    }

    private List<ProductType> getPredictedProducts(double[] distribution) {
        List<ProductType> predictedProducts = new ArrayList<>();
        for (int i = 0; i < distribution.length; i++) {
            if (distribution[i] > 0.5) { // Пример порога
                predictedProducts.add(ProductType.values()[i]);
            }
        }
        return predictedProducts;
    }
}
