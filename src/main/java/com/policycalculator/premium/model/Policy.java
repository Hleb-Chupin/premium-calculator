package com.policycalculator.premium.model;

import java.util.List;
import java.util.Objects;

public class Policy extends Entity {

    private String number;
    private String status;
    private List<PolicyObject> policyObjects;

    public Policy() {
    }

    public Policy(String number, String status, List<PolicyObject> policyObjects) {
        this.number = number;
        this.status = status;
        this.policyObjects = policyObjects;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PolicyObject> getPolicyObjects() {
        return policyObjects;
    }

    public void setPolicyObjects(List<PolicyObject> policyObjects) {
        this.policyObjects = policyObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(number, policy.number) &&
                Objects.equals(status, policy.status) &&
                Objects.equals(policyObjects, policy.policyObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, status, policyObjects);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "number='" + number + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
