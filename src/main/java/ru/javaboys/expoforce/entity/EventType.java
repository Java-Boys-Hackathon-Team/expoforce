package ru.javaboys.expoforce.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum EventType implements EnumClass<String> {

    DEAL("DEAL"),
    INTENT("INTENT");

    private final String id;

    EventType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EventType fromId(String id) {
        for (EventType at : EventType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}