package com.policycalculator.premium.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class PolicyDTO {

    private String number;
    private String status;
    private List<PolictyObjectDTO> policyObjects;

    public PolicyDTO() {
        this.number = null;
        this.status = null;
        this.policyObjects = null;
    }

    public PolicyDTO(String number, String status, List<PolictyObjectDTO> policyObjects) {
        this.number = number;
        this.status = status;
        this.policyObjects = policyObjects;
    }

    @JsonProperty(required = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty(required = true)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty(required = true)
    public List<PolictyObjectDTO> getPolicyObjects() {
        return policyObjects;
    }

    public void setPolicyObjects(List<PolictyObjectDTO> policyObjects) {
        this.policyObjects = policyObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolicyDTO that = (PolicyDTO) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(status, that.status) &&
                Objects.equals(policyObjects, that.policyObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, status, policyObjects);
    }

    @Override
    public String toString() {
        return "PolicyDTO{" +
                "number='" + number + '\'' +
                ", status='" + status + '\'' +
                ", policyObjects=" + policyObjects +
                '}';
    }
}
