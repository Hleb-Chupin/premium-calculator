package com.policycalculator.premium.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class SubObjectDTO {

    private String name;
    private Double sumInsured;
    private String riskType;

    public SubObjectDTO() {
        this.name = null;
        this.sumInsured = null;
        this.riskType = null;
    }

    public SubObjectDTO(String name, Double sumInsured, String riskType) {
        this.name = name;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }

    @JsonProperty(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(required = true)
    public Double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(Double sumInsured) {
        this.sumInsured = sumInsured;
    }

    @JsonProperty(required = true)
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
        SubObjectDTO that = (SubObjectDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(sumInsured, that.sumInsured) &&
                Objects.equals(riskType, that.riskType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sumInsured, riskType);
    }

    @Override
    public String toString() {
        return "SubObjectDTO{" +
                "name='" + name + '\'' +
                ", sumInsured=" + sumInsured +
                ", riskType='" + riskType + '\'' +
                '}';
    }
}
