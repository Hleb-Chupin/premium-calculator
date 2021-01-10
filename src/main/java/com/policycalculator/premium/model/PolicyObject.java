package com.policycalculator.premium.model;

import java.util.List;
import java.util.Objects;

public class PolicyObject extends Entity {

    private String name;
    private List<SubObject> subObjects;

    public PolicyObject() {
    }

    public PolicyObject(String name, List<SubObject> subObjects) {
        this.name = name;
        this.subObjects = subObjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubObject> getSubObjects() {
        return subObjects;
    }

    public void setSubObjects(List<SubObject> subObjects) {
        this.subObjects = subObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolicyObject that = (PolicyObject) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(subObjects, that.subObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subObjects);
    }

    @Override
    public String toString() {
        return "PolicyObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
