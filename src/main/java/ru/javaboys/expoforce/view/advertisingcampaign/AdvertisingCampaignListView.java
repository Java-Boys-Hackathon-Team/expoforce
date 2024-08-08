package ru.javaboys.expoforce.view.advertisingcampaign;

import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.kit.action.Action;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewComponent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;
import ru.javaboys.expoforce.FilterService;
import ru.javaboys.expoforce.entity.AdvertisingCampaign;
import ru.javaboys.expoforce.entity.AdvertisingCampaignRun;
import ru.javaboys.expoforce.view.advertisingcampaignrun.AdvertisingCampaignRunDetailView;
import ru.javaboys.expoforce.view.main.MainView;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@Route(value = "advertisingCampaigns", layout = MainView.class)
@ViewController("AdvertisingCampaign.list")
@ViewDescriptor("advertising-campaign-list-view.xml")
@LookupComponent("advertisingCampaignsDataGrid")
@DialogMode(width = "64em")
public class AdvertisingCampaignListView extends StandardListView<AdvertisingCampaign> {
    @ViewComponent private DataGrid<AdvertisingCampaign> advertisingCampaignsDataGrid;

    @Autowired private FilterService filterService;
    @Autowired private DataManager dataManager;
    @Autowired private TransactionTemplate transactionTemplate;
    @Autowired private ViewNavigators viewNavigators;
    @PersistenceContext private EntityManager em;

    //todo enable / disable run button

    @Subscribe("advertisingCampaignsDataGrid.runExecute")
    public void runExecute(final ActionPerformedEvent event) {
        var campaign = advertisingCampaignsDataGrid.getSingleSelectedItem();
        AdvertisingCampaignRun run = transactionTemplate.execute(ts -> {
            AdvertisingCampaignRun newRun = dataManager.create(AdvertisingCampaignRun.class);
            newRun.setCampaign(campaign);
            newRun.setRunTimestamp(OffsetDateTime.now());
            newRun = dataManager.save(newRun);

            String sql = filterService.buildInsertSqlQuery(campaign, newRun.getId());
            em.createNativeQuery(sql).executeUpdate();
            return newRun;
        });

        viewNavigators.detailView(this, AdvertisingCampaignRun.class)
                .editEntity(run)
                .navigate();
    }

}