package ru.javaboys.expoforce.view.advertisingcampaignrun;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.javaboys.expoforce.entity.AdvertisingCampaignRun;
import ru.javaboys.expoforce.view.main.MainView;


@Route(value = "advertisingCampaignRuns", layout = MainView.class)
@ViewController("AdvertisingCampaignRun.list")
@ViewDescriptor("advertising-campaign-run-list-view.xml")
@LookupComponent("advertisingCampaignRunsDataGrid")
@DialogMode(width = "64em")
public class AdvertisingCampaignRunListView extends StandardListView<AdvertisingCampaignRun> {
}