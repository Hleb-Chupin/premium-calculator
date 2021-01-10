package com.policycalculator.premium.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class SubObjectDTO {

    private Long id;
    private String name;
    private Double sumInsured;
    private String riskType;

    public SubObjectDTO() {
        this.id = null;
        this.name = null;
        this.sumInsured = null;
        this.riskType = null;
    }

    public SubObjectDTO(Long id, String name, Double sumInsured, String riskType) {
        this.id = id;
        this.name = name;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }

    @JsonProperty(required = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sumInsured, that.sumInsured) &&
                Objects.equals(riskType, that.riskType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sumInsured, riskType);
    }

    @Override
    public String toString() {
        return "SubObjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sumInsured=" + sumInsured +
                ", riskType='" + riskType + '\'' +
                '}';
    }
}
