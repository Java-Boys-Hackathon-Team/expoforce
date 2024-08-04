package ru.javaboys.expoforce.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum ProductType implements EnumClass<String> {

    BANK_CARD("BANK_CARD"),
    CREDIT("CREDIT"),
    DEPOSIT("DEPOSIT"),
    MORTGAGE("MORTGAGE"),
    CAR("CAR"),
    CAR_RENTAL("CAR_RENTAL"),
    CAR_SERVICE("CAR_SERVICE"),
    INSURANCE("INSURANCE"),
    LEGAL_SERVICE("LEGAL_SERVICE"),
    BOOKING("BOOKING"),
    BANQUETS("BANQUETS");

    private final String id;

    ProductType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ProductType fromId(String id) {
        for (ProductType at : ProductType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}