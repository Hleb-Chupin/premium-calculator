package com.policycalculator.premium.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PremiumDTOTest {

    @Test
    void equalsReturnsTrueSymmetricallyOnSameObjects() {
        PremiumDTO testPremium1 = createTestPremium(1);
        PremiumDTO testPremium2 = createTestPremium(1);
        Assertions.assertTrue(testPremium1.equals(testPremium2) && testPremium2.equals(testPremium1));
    }

    @Test
    void equalsReturnsFalseSymmetricallyOnDifferentObjects() {
        PremiumDTO testPremium1 = createTestPremium(1);
        PremiumDTO testPremium2 = createTestPremium(2);
        Assertions.assertTrue(!testPremium1.equals(testPremium2) && !testPremium2.equals(testPremium1));
    }

    @Test
    void hashCodesAreSameOnSameObjects() {
        PremiumDTO testPremium1 = createTestPremium(1);
        PremiumDTO testPremium2 = createTestPremium(1);
        Assertions.assertTrue(testPremium1.hashCode() == testPremium2.hashCode());
    }

    @Test
    void hashCodesDifferOnDiffentObjects() {
        PremiumDTO testPremium1 = createTestPremium(1);
        PremiumDTO testPremium2 = createTestPremium(2);
        Assertions.assertTrue(testPremium1.hashCode() != testPremium2.hashCode());
    }

    private PremiumDTO createTestPremium(int id){
        PremiumDTO premiumDTO = new PremiumDTO();
        premiumDTO.setId(new Long(id));
        premiumDTO.setPremiumSum(200.00);
        return premiumDTO;
    }
}
