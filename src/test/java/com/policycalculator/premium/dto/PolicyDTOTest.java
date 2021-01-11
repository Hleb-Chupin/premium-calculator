package com.policycalculator.premium.dto;

import com.policycalculator.premium.common.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PolicyDTOTest {

    @Test
    void equalsReturnsTrueSymmetricallyOnSameObjects() {
        PolicyDTO testPolicy1 = createTestPolicy(1, Constants.RiskType.FIRE);
        PolicyDTO testPolicy2 = createTestPolicy(1, Constants.RiskType.FIRE);
        Assertions.assertTrue(testPolicy1.equals(testPolicy2) && testPolicy2.equals(testPolicy1));
    }

    @Test
    void equalsReturnsFalseSymmetricallyOnDifferentObjects() {
        PolicyDTO testPolicy1 = createTestPolicy(1, Constants.RiskType.FIRE);
        PolicyDTO testPolicy2 = createTestPolicy(2, Constants.RiskType.FIRE);
        Assertions.assertTrue(!testPolicy1.equals(testPolicy2) && !testPolicy2.equals(testPolicy1));

        PolicyDTO testPolicy3 = createTestPolicy(1, Constants.RiskType.FIRE);
        PolicyDTO testPolicy4 = createTestPolicy(2, Constants.RiskType.THEFT);
        Assertions.assertTrue(!testPolicy3.equals(testPolicy4) && !testPolicy4.equals(testPolicy3));
    }

    @Test
    void hashCodesAreSameOnSameObjects() {
        PolicyDTO testPolicy1 = createTestPolicy(1, Constants.RiskType.THEFT);
        PolicyDTO testPolicy2 = createTestPolicy(1, Constants.RiskType.THEFT);
        Assertions.assertTrue(testPolicy1.hashCode() == testPolicy2.hashCode());
    }

    @Test
    void hashCodesDifferOnDiffentObjects() {
        PolicyDTO testPolicy1 = createTestPolicy(1, Constants.RiskType.THEFT);
        PolicyDTO testPolicy2 = createTestPolicy(2, Constants.RiskType.THEFT);
        Assertions.assertTrue(testPolicy1.hashCode() != testPolicy2.hashCode());

        PolicyDTO testPolicy3 = createTestPolicy(1, Constants.RiskType.FIRE);
        PolicyDTO testPolicy4 = createTestPolicy(2, Constants.RiskType.THEFT);
        Assertions.assertTrue(testPolicy3.hashCode() != testPolicy4.hashCode());
    }

    private PolicyDTO createTestPolicy(int id, Enum riskType) {
        PolicyDTO policyDTO = new PolicyDTO();
        policyDTO.setId(new Long(id));
        policyDTO.setNumber("INSURANCE-330000-BALTICS-2021");
        policyDTO.setPolicyObjects(createTestPolicys(riskType));
        policyDTO.setStatus(Constants.REGISTERED);
        return policyDTO;
    }

    private List<PolicyObjectDTO> createTestPolicys(Enum riskType) {
        List<PolicyObjectDTO> policyObjectDTOS = new ArrayList<>();

        PolicyObjectDTO policyObjectDTO1 = new PolicyObjectDTO();
        policyObjectDTO1.setId(new Long(1));
        policyObjectDTO1.setName("NEW NAME1");
        policyObjectDTO1.setSubObjects(createSubObjects(riskType));
        policyObjectDTOS.add(policyObjectDTO1);

        PolicyObjectDTO policyObjectDTO2 = new PolicyObjectDTO();
        policyObjectDTO2.setId(new Long(2));
        policyObjectDTO2.setName("NEW NAME2");
        policyObjectDTO2.setSubObjects(createSubObjects(riskType));
        policyObjectDTOS.add(policyObjectDTO1);

        return policyObjectDTOS;
    }

    private List<SubObjectDTO> createSubObjects(Enum riskType) {
        List<SubObjectDTO> subObjectDTOS = new ArrayList<>();

        SubObjectDTO subObjectDTO1 = new SubObjectDTO();
        subObjectDTO1.setId(1L);
        subObjectDTO1.setName("NEW NAME1");
        subObjectDTO1.setSumInsured(200.00);
        subObjectDTO1.setRiskType(riskType.toString());
        subObjectDTOS.add(subObjectDTO1);

        SubObjectDTO subObjectDTO2 = new SubObjectDTO();
        subObjectDTO2.setId(2L);
        subObjectDTO2.setName("NEW NAME2");
        subObjectDTO2.setSumInsured(200.00);
        subObjectDTO2.setRiskType(riskType.toString());
        subObjectDTOS.add(subObjectDTO2);

        return subObjectDTOS;
    }
}
