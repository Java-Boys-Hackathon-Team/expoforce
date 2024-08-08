package ru.javaboys.expoforce.view.advertisingcampaignfilter;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.entity.AdvertisingCampaignFilter;
import ru.javaboys.expoforce.view.main.MainView;


@Route(value = "advertisingCampaignFilters", layout = MainView.class)
@ViewController("AdvertisingCampaignFilter.list")
@ViewDescriptor("advertising-campaign-filter-list-view.xml")
@LookupComponent("advertisingCampaignFiltersDataGrid")
@DialogMode(width = "64em")
public class AdvertisingCampaignFilterListView extends StandardListView<AdvertisingCampaignFilter> {
}