package com.numberONe.entity;

public class ItemStorage {
    private String itemId	  ;
    private String itemBatch  ;
    private String proType    ;
    private String luHao      ;
    private String numIs      ;
    private String itemPrice  ;
    private String itemName   ;
    private String itemUnit   ;
    private String itemSpc    ;
    private String prvName    ;
    private String psName     ;
    private String wareName   ;
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getItemBatch() {
        return itemBatch;
    }
    public void setItemBatch(String itemBatch) {
        this.itemBatch = itemBatch;
    }
    public String getProType() {
        return proType;
    }
    public void setProType(String proType) {
        this.proType = proType;
    }
    public String getLuHao() {
        return luHao;
    }
    public void setLuHao(String luHao) {
        this.luHao = luHao;
    }

    public String getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemUnit() {
        return itemUnit;
    }
    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }
    public String getItemSpc() {
        return itemSpc;
    }
    public void setItemSpc(String itemSpc) {
        this.itemSpc = itemSpc;
    }
    public String getPrvName() {
        return prvName;
    }
    public void setPrvName(String prvName) {
        this.prvName = prvName;
    }
    public String getPsName() {
        return psName;
    }
    public void setPsName(String psName) {
        this.psName = psName;
    }
    public String getWareName() {
        return wareName;
    }
    public void setWareName(String wareName) {
        this.wareName = wareName;
    }
    public String getNumIs() {
        return numIs;
    }
    public void setNumIs(String numIs) {
        this.numIs = numIs;
    }

    @Override
    public String toString() {
        return "ItemStorage{" +
                "itemId='" + itemId + '\'' +
                ", itemBatch='" + itemBatch + '\'' +
                ", proType='" + proType + '\'' +
                ", luHao='" + luHao + '\'' +
                ", numIs='" + numIs + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemUnit='" + itemUnit + '\'' +
                ", itemSpc='" + itemSpc + '\'' +
                ", prvName='" + prvName + '\'' +
                ", psName='" + psName + '\'' +
                ", wareName='" + wareName + '\'' +
                '}';
    }
}
