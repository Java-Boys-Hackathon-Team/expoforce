package ru.javaboys.expoforce.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum ConditionType implements EnumClass<String> {

    EQUAL("E", "="),
    GT("GT", ">"),
    GTE("GTE", ">="),
    LT("LT", "<"),
    LTE("LTE", "<="),
    BETWEEN("B", null);

    private final String id;
    private final String sqlOp;

    ConditionType(String id, String sqlOp) {
        this.id = id;
        this.sqlOp = sqlOp;
    }

    public String getId() {
        return id;
    }

    public String getSqlOp() {
        return sqlOp;
    }

    @Nullable
    public static ConditionType fromId(String id) {
        for (ConditionType at : ConditionType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}