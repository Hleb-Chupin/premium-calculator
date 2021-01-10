package com.policycalculator.premium.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class PremiumDTO {

    private Double premiumSum;

    public PremiumDTO() {
        this.premiumSum = null;
    }

    public PremiumDTO(Double premiumSum) {
        this.premiumSum = premiumSum;
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
        return Objects.equals(premiumSum, that.premiumSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(premiumSum);
    }

    @Override
    public String toString() {
        return "PremiumDTO{" +
                "premiumSum=" + premiumSum +
                '}';
    }
}
