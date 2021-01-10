package com.policycalculator.premium.service;

import com.policycalculator.premium.dto.PolicyDTO;
import com.policycalculator.premium.dto.PremiumDTO;

public interface PremiumCalculatorService {

    /**
     * Calculate policy's premium sum
     *
     * @param policyDTO - policy object
     * @return calculated premium sum
     */
    PremiumDTO calculate(PolicyDTO policyDTO);

}
