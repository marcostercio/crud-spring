package com.marcos.enums;

public enum Category {
    BACK_END("Back-end"), FRONT_END("Front-end");
    private final String value;

    private Category(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    //to string
    @Override
    public String toString() {  
        return value;
    }
}
