package com.imooc.enums;

public enum Sex {
    women(0,"女"),
    men(1,"男"),
    sercet(2,"保密");
    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
