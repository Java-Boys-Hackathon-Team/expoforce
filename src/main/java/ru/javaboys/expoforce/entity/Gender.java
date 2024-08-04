package ru.javaboys.expoforce.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Gender implements EnumClass<String> {

    MALE("M"),
    FEMALE("F");

    private final String id;

    Gender(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Gender fromId(String id) {
        for (Gender at : Gender.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}