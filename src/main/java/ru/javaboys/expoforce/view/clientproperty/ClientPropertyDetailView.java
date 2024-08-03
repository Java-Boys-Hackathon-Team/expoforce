package ru.javaboys.expoforce.view.clientproperty;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.entity.ClientProperty;
import ru.javaboys.expoforce.view.main.MainView;

@Route(value = "clientProperties/:id", layout = MainView.class)
@ViewController("ClientProperty.detail")
@ViewDescriptor("client-property-detail-view.xml")
@EditedEntityContainer("clientPropertyDc")
public class ClientPropertyDetailView extends StandardDetailView<ClientProperty> {
}