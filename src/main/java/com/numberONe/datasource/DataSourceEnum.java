package com.numberONe.datasource;

public enum DataSourceEnum {

    DS1("ds1"), DS2("ds2");
    
    private String key;

    DataSourceEnum(String key) { this.key = key; }

    public String getKey() { return key; }
    
    public void setKey(String key) {  this.key = key; }
}

