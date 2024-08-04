package ru.javaboys.expoforce.view.touchpoints;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.javaboys.expoforce.entity.TouchPoints;
import ru.javaboys.expoforce.view.main.MainView;


@Route(value = "touchPointses", layout = MainView.class)
@ViewController("TouchPoints.list")
@ViewDescriptor("touch-points-list-view.xml")
@LookupComponent("touchPointsesDataGrid")
@DialogMode(width = "64em")
public class TouchPointsListView extends StandardListView<TouchPoints> {
}