package ru.javaboys.expoforce.view.advertisingcampaign;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.entity.AdvertisingCampaign;
import ru.javaboys.expoforce.view.main.MainView;

@Route(value = "advertisingCampaigns/:id", layout = MainView.class)
@ViewController("AdvertisingCampaign.detail")
@ViewDescriptor("advertising-campaign-detail-view.xml")
@EditedEntityContainer("advertisingCampaignDc")
public class AdvertisingCampaignDetailView extends StandardDetailView<AdvertisingCampaign> {
}