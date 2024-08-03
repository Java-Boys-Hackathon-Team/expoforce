package ru.javaboys.expoforce.view.event;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.entity.Event;
import ru.javaboys.expoforce.view.main.MainView;

@Route(value = "events/:id", layout = MainView.class)
@ViewController("Event.detail")
@ViewDescriptor("event-detail-view.xml")
@EditedEntityContainer("eventDc")
public class EventDetailView extends StandardDetailView<Event> {
}