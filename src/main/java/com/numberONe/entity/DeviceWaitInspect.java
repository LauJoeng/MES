package com.numberONe.entity;

public class DeviceWaitInspect {
    private Integer id;
    private String inspectMan;
    private String dNumber;
    private String dName;
    private String name;
    private Integer cycle;
    private Integer planId;

    public DeviceWaitInspect() {
    }

    public DeviceWaitInspect(String inspectMan, String dNumber, String dName, String name, Integer cycle, Integer planId) {
        this.inspectMan = inspectMan;
        this.dNumber = dNumber;
        this.dName = dName;
        this.name = name;
        this.cycle = cycle;
        this.planId = planId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInspectMan() {
        return inspectMan;
    }

    public void setInspectMan(String inspectMan) {
        this.inspectMan = inspectMan;
    }

    public String getdNumber() {
        return dNumber;
    }

    public void setdNumber(String dNumber) {
        this.dNumber = dNumber;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "DeviceWaitInspect{" +
                "id=" + id +
                ", inspectMan='" + inspectMan + '\'' +
                ", dNumber='" + dNumber + '\'' +
                ", dName='" + dName + '\'' +
                ", name='" + name + '\'' +
                ", cycle=" + cycle +
                ", planId=" + planId +
                '}';
    }
}
