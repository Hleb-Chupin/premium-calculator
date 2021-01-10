package com.policycalculator.premium.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class PolictyObjectDTO {

    private String name;
    private List<SubObjectDTO> subObjects;

    public PolictyObjectDTO() {
        this.name = null;
        this.subObjects = null;
    }

    public PolictyObjectDTO(String name, List<SubObjectDTO> subObjects) {
        this.name = name;
        this.subObjects = subObjects;
    }

    @JsonProperty(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(required = true)
    public List<SubObjectDTO> getSubObjects() {
        return subObjects;
    }

    public void setSubObjects(List<SubObjectDTO> subObjects) {
        this.subObjects = subObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolictyObjectDTO that = (PolictyObjectDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(subObjects, that.subObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subObjects);
    }

    @Override
    public String toString() {
        return "PolictyObjectDTO{" +
                "name='" + name + '\'' +
                ", subObjects=" + subObjects +
                '}';
    }
}
