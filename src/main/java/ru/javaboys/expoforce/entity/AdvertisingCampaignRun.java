package ru.javaboys.expoforce.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ADVERTISING_CAMPAIGN_RUN", indexes = {
        @Index(name = "IDX_ADVERTISING_CAMPAIGN_RUN_CAMPAIGN", columnList = "CAMPAIGN_ID"),
        @Index(name = "IDX_ADVERTISING_CAMPAIGN_RUN_PRODUCT", columnList = "PRODUCT_ID")
})
@Entity
public class AdvertisingCampaignRun {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "PRODUCT_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    @JoinColumn(name = "CAMPAIGN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AdvertisingCampaign campaign;

    @Composition
    @OneToMany(mappedBy = "advertisingCampaignRun")
    private List<AdvertisingCampaignRunClient> clients;

    @Column(name = "RUN_TIMESTAMP")
    private OffsetDateTime runTimestamp;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OffsetDateTime getRunTimestamp() {
        return runTimestamp;
    }

    public void setRunTimestamp(OffsetDateTime runTimestamp) {
        this.runTimestamp = runTimestamp;
    }

    public List<AdvertisingCampaignRunClient> getClients() {
        return clients;
    }

    public void setClients(List<AdvertisingCampaignRunClient> clients) {
        this.clients = clients;
    }

    public AdvertisingCampaign getCampaign() {
        return campaign;
    }

    public void setCampaign(AdvertisingCampaign campaign) {
        this.campaign = campaign;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}