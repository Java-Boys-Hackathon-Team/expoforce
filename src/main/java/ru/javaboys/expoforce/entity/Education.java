package ru.javaboys.expoforce.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Education implements EnumClass<String> {

    HIGHER("H"),
    SECONDARY("S"),
    PRIMARY("P");

    private final String id;

    Education(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Education fromId(String id) {
        for (Education at : Education.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}