package ru.javaboys.expoforce.view.event;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.javaboys.expoforce.entity.Event;
import ru.javaboys.expoforce.view.main.MainView;


@Route(value = "events", layout = MainView.class)
@ViewController("Event.list")
@ViewDescriptor("event-list-view.xml")
@LookupComponent("eventsDataGrid")
@DialogMode(width = "64em")
public class EventListView extends StandardListView<Event> {
}