package ru.javaboys.expoforce.view.dataimport;


import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.view.main.MainView;

@Route(value = "DataImport", layout = MainView.class)
@ViewController("Dataimport")
@ViewDescriptor("DataImport.xml")
public class DataImport extends StandardView {
}