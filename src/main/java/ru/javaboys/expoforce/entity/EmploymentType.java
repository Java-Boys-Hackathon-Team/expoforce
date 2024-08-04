package ru.javaboys.expoforce.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum EmploymentType implements EnumClass<String> {

    EMPLOYED("EM"),
    INDIVIDUAL_ENTREPRENEUR("IE"),
    SELF_EMPLOYED("SE"),
    RETIRED("RE"),
    OWN_BUSINESS("OB");

    private final String id;

    EmploymentType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EmploymentType fromId(String id) {
        for (EmploymentType at : EmploymentType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}