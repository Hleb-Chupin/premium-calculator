package com.policycalculator.premium.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class PolicyObjectDTO {

    private Long id;
    private String name;
    private List<SubObjectDTO> subObjects;

    public PolicyObjectDTO() {
        this.id = null;
        this.name = null;
        this.subObjects = null;
    }

    public PolicyObjectDTO(Long id, String name, List<SubObjectDTO> subObjects) {
        this.id = id;
        this.name = name;
        this.subObjects = subObjects;
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
        PolicyObjectDTO that = (PolicyObjectDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(subObjects, that.subObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subObjects);
    }

    @Override
    public String toString() {
        return "PolicyObjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subObjects=" + subObjects +
                '}';
    }
}
