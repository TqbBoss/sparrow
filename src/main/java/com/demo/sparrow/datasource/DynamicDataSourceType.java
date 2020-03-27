package com.demo.sparrow.datasource;

public enum DynamicDataSourceType {
    master("master"),
    slave("slave");

    private String value;

    DynamicDataSourceType(String typeValue) {
        this.value = typeValue;
    }

    public String getValue(){
        return this.value;
    }
}
