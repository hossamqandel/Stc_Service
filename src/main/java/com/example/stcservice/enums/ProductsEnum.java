package com.example.stcservice.enums;

public enum ProductsEnum {

    SAMSUNG("Samsung"),
    PLAYSTATION("Playstation");

    private String value;

    ProductsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
