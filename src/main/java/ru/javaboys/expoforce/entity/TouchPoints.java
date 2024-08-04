package ru.javaboys.expoforce.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.UUID;

@JmixEntity
@Table(name = "TOUCH_POINTS", indexes = {
        @Index(name = "IDX_TOUCH_POINTS_CLIENT", columnList = "CLIENT_ID")
})
@Entity
public class TouchPoints {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "CLIENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @Column(name = "COST", precision = 19)
    private BigInteger cost;

    @Column(name = "INTERACTED")
    private Boolean interacted;

    @Column(name = "PURCHASED")
    private Boolean purchased;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    public ProductType getProductType() {
        return productType == null ? null : ProductType.fromId(productType);
    }

    public void setProductType(ProductType productType) {
        this.productType = productType == null ? null : productType.getId();
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }

    public Boolean getInteracted() {
        return interacted;
    }

    public void setInteracted(Boolean interacted) {
        this.interacted = interacted;
    }

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
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