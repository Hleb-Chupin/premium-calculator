package com.policycalculator.premium.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class PolicyDTO {

    private Long id;
    private String number;
    private String status;
    private List<PolicyObjectDTO> policyObjects;

    public PolicyDTO() {
        this.id = null;
        this.number = null;
        this.status = null;
        this.policyObjects = null;
    }

    public PolicyDTO(Long id, String number, String status, List<PolicyObjectDTO> policyObjects) {
        this.id = id;
        this.number = number;
        this.status = status;
        this.policyObjects = policyObjects;
    }

    @JsonProperty(required = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public List<PolicyObjectDTO> getPolicyObjects() {
        return policyObjects;
    }

    public void setPolicyObjects(List<PolicyObjectDTO> policyObjects) {
        this.policyObjects = policyObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolicyDTO policyDTO = (PolicyDTO) o;
        return Objects.equals(id, policyDTO.id) &&
                Objects.equals(number, policyDTO.number) &&
                Objects.equals(status, policyDTO.status) &&
                Objects.equals(policyObjects, policyDTO.policyObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, status, policyObjects);
    }

    @Override
    public String toString() {
        return "PolicyDTO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", status='" + status + '\'' +
                ", policyObjects=" + policyObjects +
                '}';
    }
}
