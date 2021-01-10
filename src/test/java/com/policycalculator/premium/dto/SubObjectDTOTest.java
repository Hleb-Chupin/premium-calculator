package com.policycalculator.premium.dto;

import com.policycalculator.premium.common.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubObjectDTOTest {

    @Test
    void equalsReturnsTrueSymmetricallyOnSameObjects() {
        SubObjectDTO testSubObject1 = createTestSubObject(1);
        SubObjectDTO testSubObject2 = createTestSubObject(1);
        Assertions.assertTrue(testSubObject1.equals(testSubObject2) && testSubObject2.equals(testSubObject1));
    }

    @Test
    void equalsReturnsFalseSymmetricallyOnDifferentObjects() {
        SubObjectDTO testSubObject1 = createTestSubObject(1);
        SubObjectDTO testSubObject2 = createTestSubObject(2);
        Assertions.assertTrue(!testSubObject1.equals(testSubObject2) && !testSubObject2.equals(testSubObject1));
    }

    @Test
    void hashCodesAreSameOnSameObjects() {
        SubObjectDTO testSubObject1 = createTestSubObject(1);
        SubObjectDTO testSubObject2 = createTestSubObject(1);
        Assertions.assertTrue(testSubObject1.hashCode() == testSubObject2.hashCode());
    }

    @Test
    void hashCodesDifferOnDiffentObjects() {
        SubObjectDTO testSubObject1 = createTestSubObject(1);
        SubObjectDTO testSubObject2 = createTestSubObject(2);
        Assertions.assertTrue(testSubObject1.hashCode() != testSubObject2.hashCode());
    }

    private SubObjectDTO createTestSubObject(int id){
        SubObjectDTO subObjectDTO = new SubObjectDTO();
        subObjectDTO.setId(new Long(id));
        subObjectDTO.setName("NEW NAME");
        subObjectDTO.setRiskType(Constants.RiskType.FIRE.toString());
        subObjectDTO.setSumInsured(200.00);
        return subObjectDTO;
    }
}
