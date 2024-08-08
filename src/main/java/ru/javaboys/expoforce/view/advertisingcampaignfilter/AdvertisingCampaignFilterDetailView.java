package ru.javaboys.expoforce.view.advertisingcampaignfilter;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.entity.AdvertisingCampaignFilter;
import ru.javaboys.expoforce.view.main.MainView;

@Route(value = "advertisingCampaignFilters/:id", layout = MainView.class)
@ViewController("AdvertisingCampaignFilter.detail")
@ViewDescriptor("advertising-campaign-filter-detail-view.xml")
@EditedEntityContainer("advertisingCampaignFilterDc")
public class AdvertisingCampaignFilterDetailView extends StandardDetailView<AdvertisingCampaignFilter> {
}