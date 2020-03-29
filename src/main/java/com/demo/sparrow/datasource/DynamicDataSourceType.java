package com.demo.sparrow.datasource;

public enum DynamicDataSourceType {
    master(DynamicDataSourceConfiguration.MASTER_DATASOURCE),
    slave(DynamicDataSourceConfiguration.SLAVE_DATASOURCE);

    private String value;

    DynamicDataSourceType(String typeValue) {
        this.value = typeValue;
    }

    public String getValue(){
        return this.value;
    }
}
