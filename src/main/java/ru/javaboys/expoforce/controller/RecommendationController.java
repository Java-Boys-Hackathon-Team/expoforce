package ru.javaboys.expoforce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.javaboys.expoforce.ml.DataPreparation;
import ru.javaboys.expoforce.ml.RecommendationModelService;
import weka.core.Instances;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private DataPreparation dataPreparationService;

    @Autowired
    private RecommendationModelService recommendationModelService;

    // Метод для обучения модели
    @PostMapping("/train")
    public String trainModel() {
        Instances trainingData = dataPreparationService.prepareTrainingData();
        recommendationModelService.trainModel(trainingData);
        return "Модель успешно обучена";
    }

    // Метод для получения рекомендаций
    @GetMapping("/predict")
    public String getRecommendation(
        @RequestParam("age") int age,
        @RequestParam("incomeAmount") double incomeAmount,
        @RequestParam("married") boolean married,
        @RequestParam("productPrice") double productPrice,
        @RequestParam("productType") String productType
    ) {
        // Примерный набор данных для предсказания
        double[] instanceValues = new double[]{age, incomeAmount, married ? 1.0 : 0.0, productPrice, productType.equals("someType") ? 1.0 : 0.0};

        double result = recommendationModelService.predict(instanceValues);
        
        // Обработка результата предсказания
        if (result == 1.0) {
            return "Клиент, вероятно, заинтересуется предложением.";
        } else {
            return "Клиент, вероятно, не заинтересуется предложением.";
        }
    }
}
