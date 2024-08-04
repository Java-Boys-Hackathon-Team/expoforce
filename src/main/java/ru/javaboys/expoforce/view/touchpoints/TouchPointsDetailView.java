package ru.javaboys.expoforce.view.touchpoints;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.entity.TouchPoints;
import ru.javaboys.expoforce.view.main.MainView;

@Route(value = "touchPointses/:id", layout = MainView.class)
@ViewController("TouchPoints.detail")
@ViewDescriptor("touch-points-detail-view.xml")
@EditedEntityContainer("touchPointsDc")
public class TouchPointsDetailView extends StandardDetailView<TouchPoints> {
}