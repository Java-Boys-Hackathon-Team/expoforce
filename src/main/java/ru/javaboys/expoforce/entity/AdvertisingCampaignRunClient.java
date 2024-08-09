package ru.javaboys.expoforce.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@JmixEntity
@Table(name = "ADVERTISING_CAMPAIGN_RUN_CLIENT", indexes = {
        @Index(name = "IDX_ADVERTISING_CAMPAIGN_RUN_CLIENT_CLIENT", columnList = "CLIENT_ID"),
        @Index(name = "IDX_ADVERTISING_CAMPAIGN_RUN_CLIENT_ADVERTISING_CAMPAIGN_RUN", columnList = "ADVERTISING_CAMPAIGN_RUN_ID")
})
@Entity
public class AdvertisingCampaignRunClient {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "CLIENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @Column(name = "SENT_EMAIL")
    private Boolean sentEmail;

    @Column(name = "WAS_CALLED")
    private Boolean wasCalled;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "ADVERTISING_CAMPAIGN_RUN_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private AdvertisingCampaignRun advertisingCampaignRun;

    public Boolean getWasCalled() {
        return wasCalled;
    }

    public void setWasCalled(Boolean wasCalled) {
        this.wasCalled = wasCalled;
    }

    public Boolean getSentEmail() {
        return sentEmail;
    }

    public void setSentEmail(Boolean sentEmail) {
        this.sentEmail = sentEmail;
    }

    public AdvertisingCampaignRun getAdvertisingCampaignRun() {
        return advertisingCampaignRun;
    }

    public void setAdvertisingCampaignRun(AdvertisingCampaignRun advertisingCampaignRun) {
        this.advertisingCampaignRun = advertisingCampaignRun;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}