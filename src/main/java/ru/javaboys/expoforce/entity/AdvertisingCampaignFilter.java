package ru.javaboys.expoforce.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "ADVERTISING_CAMPAIGN_FILTER", indexes = {
        @Index(name = "IDX_ADVERTISING_CAMPAIGN_FILTER_ADVERTISING_CAMPAIGN", columnList = "ADVERTISING_CAMPAIGN_ID")
})
@Entity
public class AdvertisingCampaignFilter {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "FIELD_NAME")
    private String field;

    @Column(name = "CONDITION_")
    private String condition;

    @Column(name = "VALUE1")
    private String value1;

    @Column(name = "VALUE2")
    private String value2;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private OffsetDateTime deletedDate;

    @JoinColumn(name = "ADVERTISING_CAMPAIGN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AdvertisingCampaign advertisingCampaign;

    public AdvertisingCampaign getAdvertisingCampaign() {
        return advertisingCampaign;
    }

    public void setAdvertisingCampaign(AdvertisingCampaign advertisingCampaign) {
        this.advertisingCampaign = advertisingCampaign;
    }

    public void setField(ClientFieldType field) {
        this.field = field == null ? null : field.getId();
    }

    public ClientFieldType getField() {
        return field == null ? null : ClientFieldType.fromId(field);
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public ConditionType getCondition() {
        return condition == null ? null : ConditionType.fromId(condition);
    }

    public void setCondition(ConditionType condition) {
        this.condition = condition == null ? null : condition.getId();
    }

    public OffsetDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(OffsetDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}