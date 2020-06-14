package com.destroyyouth.personsandhobbies.commons.enums;

public enum Gender {

    MALE("m"), FEMALE("f"), OTHER("o");

    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public static Boolean exists(String value) {
        for (Gender e : values()) {
            if (e.value.equals(value)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
