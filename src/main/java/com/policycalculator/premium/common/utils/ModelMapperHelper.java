package com.policycalculator.premium.common.utils;

import com.policycalculator.premium.dto.PolicyDTO;
import com.policycalculator.premium.dto.PolicyObjectDTO;
import com.policycalculator.premium.dto.SubObjectDTO;
import com.policycalculator.premium.model.Policy;
import com.policycalculator.premium.model.PolicyObject;
import com.policycalculator.premium.model.SubObject;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import java.util.ArrayList;
import java.util.List;

public class ModelMapperHelper {

    private static ModelMapper modelMapperInstance;

    public static ModelMapper getModelMapperInstance() {
        if (modelMapperInstance == null) {
            modelMapperInstance = getModelMapper();
        }

        return modelMapperInstance;
    }

    private static ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<PolicyDTO, Policy> policyDTOtoPolicyConverter = new Converter<PolicyDTO, Policy>() {
            public Policy convert(MappingContext<PolicyDTO, Policy> context) {
                PolicyDTO sourcePolicyDTO = context.getSource();
                if (sourcePolicyDTO == null) {
                    return null;
                }

                Policy destinationPolicy = context.getDestination();
                if (destinationPolicy == null) {
                    destinationPolicy = new Policy();
                }

                if (sourcePolicyDTO.getNumber() != null) {
                    destinationPolicy.setNumber(sourcePolicyDTO.getNumber());
                }

                if (!sourcePolicyDTO.getPolicyObjects().isEmpty()) {
                    List<PolicyObject> policyObjectList = new ArrayList<>();

                    for (PolicyObjectDTO policyObjectDTO : sourcePolicyDTO.getPolicyObjects()) {
                        policyObjectList.add(policyObjectDTOtoPolicyObject(policyObjectDTO));
                    }

                    destinationPolicy.setPolicyObjects(policyObjectList);
                }

                if (sourcePolicyDTO.getStatus() != null) {
                    destinationPolicy.setStatus(sourcePolicyDTO.getStatus());
                }

                return destinationPolicy;
            }
        };
        modelMapper.addConverter(policyDTOtoPolicyConverter);

        return modelMapper;
    }

    private static PolicyObject policyObjectDTOtoPolicyObject(PolicyObjectDTO policyObjectDTO) {
        PolicyObject policyObject = new PolicyObject();
        policyObject.setId(policyObjectDTO.getId());
        policyObject.setName(policyObjectDTO.getName());

        List<SubObject> subObjects = new ArrayList<>();
        if (policyObjectDTO.getSubObjects() != null) {
            for (SubObjectDTO subObjectDTO : policyObjectDTO.getSubObjects()) {
                subObjects.add(subObjectDTOtoSubobject(subObjectDTO));
            }
        }
        policyObject.setSubObjects(subObjects);
        return policyObject;
    }

    private static SubObject subObjectDTOtoSubobject(SubObjectDTO subObjectDTO) {
        SubObject subObject = new SubObject();
        subObject.setId(subObjectDTO.getId());
        subObject.setName(subObjectDTO.getName());
        subObject.setRiskType(subObjectDTO.getRiskType());
        subObject.setSumInsured(subObjectDTO.getSumInsured());
        return subObject;
    }
}
