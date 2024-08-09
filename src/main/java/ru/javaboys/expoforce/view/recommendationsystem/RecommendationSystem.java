package ru.javaboys.expoforce.view.recommendationsystem;


import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javaboys.expoforce.view.main.MainView;

@Route(value = "recommendation_system", layout = MainView.class)
@ViewController("RecommendationSystem")
@ViewDescriptor("recommendation_system.xml")
public class RecommendationSystem extends StandardView {

    @Autowired
    private RecommendationController recommendationController;

    @Subscribe(id = "button", subject = "clickListener")
    public void onButtonClick(final ClickEvent<JmixButton> event) {
        recommendationController.trainModel();
    }
}