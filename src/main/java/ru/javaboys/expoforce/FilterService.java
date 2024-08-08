package ru.javaboys.expoforce;

import ch.qos.logback.core.net.server.Client;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javaboys.expoforce.entity.AdvertisingCampaign;
import ru.javaboys.expoforce.entity.AdvertisingCampaignFilter;
import ru.javaboys.expoforce.entity.ConditionType;

import java.util.List;
import java.util.UUID;

@Service
public class FilterService {
    private final DataManager dataManager;

    @Autowired
    public FilterService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public String buildInsertSqlQuery(final AdvertisingCampaign campaign, UUID runId) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ADVERTISING_CAMPAIGN_RUN_CLIENT(id, client_id, sent_email, was_called, advertising_campaign_run_id) ")
          .append("select uuid_generate_v4(), sc.id, false, false, ")
          .append("'")
          .append(runId)
          .append("'")
          .append(" from (")
          .append(buildSelectSqlQuery(campaign))
          .append(") as sc");

        return sb.toString();
    }

    public String buildSelectSqlQuery(final AdvertisingCampaign campaign) {
        StringBuilder sb = new StringBuilder();
        sb.append("select c.* from CLIENT c where 1=1");
        for (AdvertisingCampaignFilter filter : campaign.getFilters()) {
            sb.append(" and (")
              .append("c.")
              .append(filter.getField().getName())
              .append(" ");
            if (filter.getCondition() == ConditionType.BETWEEN) {
                sb.append("between ")
                  .append(filter.getValue1())
                  .append(" and ")
                  .append(filter.getValue2());
            } else {
                sb.append(filter.getCondition().getSqlOp());
                if (filter.getField().isLiteral()) {
                    sb.append("'")
                      .append(filter.getValue1())
                      .append("'");
                } else {
                    sb.append(filter.getValue1());
                }
            }
            sb.append(")");
        }

        return sb.toString();
    }

}
