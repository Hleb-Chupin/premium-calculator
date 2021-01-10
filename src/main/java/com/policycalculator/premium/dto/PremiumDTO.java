package com.policycalculator.premium.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class PremiumDTO {

    private Long id;
    private Double premiumSum;

    public PremiumDTO() {
        this.id = null;
        this.premiumSum = null;
    }

    public PremiumDTO(Long id, Double premiumSum) {
        this.id = id;
        this.premiumSum = premiumSum;
    }

    @JsonProperty(required = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty
    public Double getPremiumSum() {
        return premiumSum;
    }

    public void setPremiumSum(Double premiumSum) {
        this.premiumSum = premiumSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PremiumDTO that = (PremiumDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(premiumSum, that.premiumSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, premiumSum);
    }

    @Override
    public String toString() {
        return "PremiumDTO{" +
                "id=" + id +
                ", premiumSum=" + premiumSum +
                '}';
    }
}
