package com.policycalculator.premium.model;

import java.util.Objects;

public class SubObject extends Entity {

    private String name;
    private double sumInsured;
    private String riskType;

    public SubObject() {
    }

    public SubObject(String name, double sumInsured, String riskType) {
        this.name = name;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubObject subObject = (SubObject) o;
        return Double.compare(subObject.sumInsured, sumInsured) == 0 &&
                Objects.equals(name, subObject.name) &&
                Objects.equals(riskType, subObject.riskType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sumInsured, riskType);
    }

    @Override
    public String toString() {
        return "SubObject{" +
                "name='" + name + '\'' +
                ", sumInsured=" + sumInsured +
                ", riskType='" + riskType + '\'' +
                '}';
    }
}
