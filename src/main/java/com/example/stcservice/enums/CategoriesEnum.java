package com.example.stcservice.enums;

public enum CategoriesEnum {

    ELECTRONICS("Electronics"),
    BEAUTY_HEALTH("Beauty_Health");

    private String value;

    CategoriesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
