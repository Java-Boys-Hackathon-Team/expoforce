package ru.javaboys.expoforce.view.source;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.entity.Source;
import ru.javaboys.expoforce.view.main.MainView;


@Route(value = "sources", layout = MainView.class)
@ViewController("Source.list")
@ViewDescriptor("source-list-view.xml")
@LookupComponent("sourcesDataGrid")
@DialogMode(width = "64em")
public class SourceListView extends StandardListView<Source> {
}