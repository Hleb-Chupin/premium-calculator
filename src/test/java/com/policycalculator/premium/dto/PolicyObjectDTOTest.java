package com.policycalculator.premium.dto;

import com.policycalculator.premium.common.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PolicyObjectDTOTest {

    @Test
    void equalsReturnsTrueSymmetricallyOnSameObjects() {
        PolicyObjectDTO testPolicyObject1 = createTestPolicyObject(1, Constants.riskType.FIRE);
        PolicyObjectDTO testPolicyObject2 = createTestPolicyObject(1, Constants.riskType.FIRE);
        Assertions.assertTrue(testPolicyObject1.equals(testPolicyObject2) && testPolicyObject2.equals(testPolicyObject1));
    }

    @Test
    void equalsReturnsFalseSymmetricallyOnDifferentObjects() {
        PolicyObjectDTO testPolicyObject1 = createTestPolicyObject(1, Constants.riskType.FIRE);
        PolicyObjectDTO testPolicyObject2 = createTestPolicyObject(2, Constants.riskType.FIRE);
        Assertions.assertTrue(!testPolicyObject1.equals(testPolicyObject2) && !testPolicyObject2.equals(testPolicyObject1));

        PolicyObjectDTO testPolicyObject3 = createTestPolicyObject(1, Constants.riskType.FIRE);
        PolicyObjectDTO testPolicyObject4 = createTestPolicyObject(2, Constants.riskType.THEFT);
        Assertions.assertTrue(!testPolicyObject3.equals(testPolicyObject4) && !testPolicyObject4.equals(testPolicyObject3));
    }

    @Test
    void hashCodesAreSameOnSameObjects() {
        PolicyObjectDTO testPolicyObject1 = createTestPolicyObject(1, Constants.riskType.THEFT);
        PolicyObjectDTO testPolicyObject2 = createTestPolicyObject(1, Constants.riskType.THEFT);
        Assertions.assertTrue(testPolicyObject1.hashCode() == testPolicyObject2.hashCode());
    }

    @Test
    void hashCodesDifferOnDiffentObjects() {
        PolicyObjectDTO testPolicyObject1 = createTestPolicyObject(1, Constants.riskType.THEFT);
        PolicyObjectDTO testPolicyObject2 = createTestPolicyObject(2, Constants.riskType.THEFT);
        Assertions.assertTrue(testPolicyObject1.hashCode() != testPolicyObject2.hashCode());

        PolicyObjectDTO testPolicyObject3 = createTestPolicyObject(1, Constants.riskType.FIRE);
        PolicyObjectDTO testPolicyObject4 = createTestPolicyObject(2, Constants.riskType.THEFT);
        Assertions.assertTrue(testPolicyObject3.hashCode() != testPolicyObject4.hashCode());
    }

    private PolicyObjectDTO createTestPolicyObject(int id, Enum riskType) {
        PolicyObjectDTO policyObjectDTO = new PolicyObjectDTO();
        policyObjectDTO.setId(new Long(id));
        policyObjectDTO.setName("NEW NAME");
        policyObjectDTO.setSubObjects(createSubObjects(riskType));

        return policyObjectDTO;
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
