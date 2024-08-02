package ru.javaboys.expoforce.view.source;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.entity.Source;
import ru.javaboys.expoforce.view.main.MainView;

@Route(value = "sources/:id", layout = MainView.class)
@ViewController("Source.detail")
@ViewDescriptor("source-detail-view.xml")
@EditedEntityContainer("sourceDc")
public class SourceDetailView extends StandardDetailView<Source> {
}