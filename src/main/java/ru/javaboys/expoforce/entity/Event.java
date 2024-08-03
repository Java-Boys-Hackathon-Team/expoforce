package ru.javaboys.expoforce.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "EVENT", indexes = {
        @Index(name = "IDX_EVENT_SOURCE", columnList = "SOURCE_ID"),
        @Index(name = "IDX_EVENT_CLIENT", columnList = "CLIENT_ID"),
        @Index(name = "IDX_EVENT_PRODUCT", columnList = "PRODUCT_ID")
})
@Entity
public class Event {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "EV_TYPE")
    private String evType;

    @Column(name = "EV_DATE")
    private LocalDateTime evDate;

    @JoinColumn(name = "SOURCE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Source source;

    @JoinColumn(name = "CLIENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @JoinColumn(name = "PRODUCT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public void setEvDate(LocalDateTime evDate) {
        this.evDate = evDate;
    }

    public LocalDateTime getEvDate() {
        return evDate;
    }

    public EventType getEvType() {
        return evType == null ? null : EventType.fromId(evType);
    }

    public void setEvType(EventType evType) {
        this.evType = evType == null ? null : evType.getId();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}