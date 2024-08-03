package ru.javaboys.expoforce.view.product;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.javaboys.expoforce.entity.Product;
import ru.javaboys.expoforce.view.main.MainView;


@Route(value = "products", layout = MainView.class)
@ViewController("Product.list")
@ViewDescriptor("product-list-view.xml")
@LookupComponent("productsDataGrid")
@DialogMode(width = "64em")
public class ProductListView extends StandardListView<Product> {
}