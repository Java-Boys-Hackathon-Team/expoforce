package ru.javaboys.expoforce.view.clientproperty;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.javaboys.expoforce.entity.ClientProperty;
import ru.javaboys.expoforce.view.main.MainView;


@Route(value = "clientProperties", layout = MainView.class)
@ViewController("ClientProperty.list")
@ViewDescriptor("client-property-list-view.xml")
@LookupComponent("clientPropertiesDataGrid")
@DialogMode(width = "64em")
public class ClientPropertyListView extends StandardListView<ClientProperty> {
}