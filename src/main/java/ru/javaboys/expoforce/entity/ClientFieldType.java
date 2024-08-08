package ru.javaboys.expoforce.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;

public enum ClientFieldType implements EnumClass<String> {
    GENDER("G", "gender", true),
    AGE("A", "age", false),
    EDUCATION("E", "education", true),
    CITY_OF_RESIDENCE("COR", "cityOfResidence", true),
    POSITION("P", "position", true),
    HAVE_FOREIGN_PASSPORT("HFP", "haveForeignPassport", false),
    HAVE_DRIVER_LICENSE("HDL", "haveDriverLicense", false),
    SENIORITY("S", "seniority", false),
    INCOME_AMOUNT("IC", "incomeAmount", false),
    EMPLOYMENT_TYPE("ET", "employmentType", true),
    MARRIED("M", "married", false),
    AMOUNT_OF_CHILDREN("AOC", "amountOfChildren", false),
    HAVE_OWN_HOME("HOH", "haveOwnHome", false),
    WORK_ORGANIZATION("WO", "workOrganization", true)
    ;

    private final String id;
    private final String name;
    private final boolean literal;

    ClientFieldType(String id, String name, boolean literal) {
        this.id = id;
        this.name = name;
        this.literal = literal;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isLiteral() {
        return literal;
    }

    @Nullable
    public static ClientFieldType fromId(String id) {
        for (ClientFieldType at : ClientFieldType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}