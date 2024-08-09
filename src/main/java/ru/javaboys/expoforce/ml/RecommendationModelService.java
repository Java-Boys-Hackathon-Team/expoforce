package ru.javaboys.expoforce.ml;

import org.springframework.stereotype.Service;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationModelService {

    private J48 decisionTree;

    public void trainModel(Instances data) {
        decisionTree = new J48(); // J48 - реализация дерева решений в Weka
        try {
            decisionTree.buildClassifier(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double predict(double[] instanceValues) {
        try {
            Instances data = prepareInstances(instanceValues);
            return decisionTree.classifyInstance(data.firstInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Возвращает -1, если возникла ошибка
    }

    private Instances prepareInstances(double[] instanceValues) {
        // Создание экземпляра Instances для одной выборки
        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("age"));
        attributes.add(new Attribute("incomeAmount"));
        attributes.add(new Attribute("married"));
        attributes.add(new Attribute("productPrice"));
        attributes.add(new Attribute("productType"));

        Instances data = new Instances("Instance", attributes, 1);
        DenseInstance instance = new DenseInstance(attributes.size());
        for (int i = 0; i < instanceValues.length; i++) {
            instance.setValue(attributes.get(i), instanceValues[i]);
        }
        data.add(instance);
        data.setClassIndex(data.numAttributes() - 1);
        return data;
    }
}
