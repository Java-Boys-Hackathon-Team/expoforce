package ru.javaboys.expoforce.view.advertisingcampaignrun;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.checkbox.JmixCheckbox;
import io.jmix.flowui.component.image.JmixImage;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.Supply;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javaboys.expoforce.entity.AdvertisingCampaignRun;
import ru.javaboys.expoforce.entity.AdvertisingCampaignRunClient;
import ru.javaboys.expoforce.view.main.MainView;

@Route(value = "advertisingCampaignRuns/:id", layout = MainView.class)
@ViewController("AdvertisingCampaignRun.detail")
@ViewDescriptor("advertising-campaign-run-detail-view.xml")
@EditedEntityContainer("advertisingCampaignRunDc")
public class AdvertisingCampaignRunDetailView extends StandardDetailView<AdvertisingCampaignRun> {

    @Autowired private UiComponents uiComponents;

//    @Supply(to = "clientsDataGrid.wasCalled", subject = "renderer")
//    private Renderer<AdvertisingCampaignRunClient> clientsDataGridWasCalledRenderer() {
//        return new ComponentRenderer<>(userStep -> {
//            JmixCheckbox checkbox = uiComponents.create(JmixCheckbox.class);
//            checkbox.setValue(userStep.getWasCalled() != null);
//            checkbox.addValueChangeListener(e -> {
//                // ...
//            });
//            return checkbox;
//        });
//    }

}