package ru.javaboys.expoforce.view.productproperty;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.javaboys.expoforce.entity.ProductProperty;
import ru.javaboys.expoforce.view.main.MainView;


@Route(value = "productProperties", layout = MainView.class)
@ViewController("ProductProperty.list")
@ViewDescriptor("product-property-list-view.xml")
@LookupComponent("productPropertiesDataGrid")
@DialogMode(width = "64em")
public class ProductPropertyListView extends StandardListView<ProductProperty> {
}