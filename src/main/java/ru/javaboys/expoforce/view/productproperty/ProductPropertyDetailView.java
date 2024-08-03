package ru.javaboys.expoforce.view.productproperty;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.entity.ProductProperty;
import ru.javaboys.expoforce.view.main.MainView;

@Route(value = "productProperties/:id", layout = MainView.class)
@ViewController("ProductProperty.detail")
@ViewDescriptor("product-property-detail-view.xml")
@EditedEntityContainer("productPropertyDc")
public class ProductPropertyDetailView extends StandardDetailView<ProductProperty> {
}