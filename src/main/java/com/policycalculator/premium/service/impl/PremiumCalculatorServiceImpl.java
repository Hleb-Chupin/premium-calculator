package com.policycalculator.premium.service.impl;

import com.policycalculator.premium.common.utils.Constants;
import com.policycalculator.premium.dto.PolicyDTO;
import com.policycalculator.premium.dto.PolicyObjectDTO;
import com.policycalculator.premium.dto.PremiumDTO;
import com.policycalculator.premium.dto.SubObjectDTO;
import com.policycalculator.premium.http.exceptions.BadRequestException;
import com.policycalculator.premium.service.PremiumCalculatorService;
import com.policycalculator.premium.service.PremiumCalculatorServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PremiumCalculatorServiceImpl implements PremiumCalculatorService {

    private static final Logger LOG = LoggerFactory.getLogger(PremiumCalculatorServiceImpl.class);

    @Override
    public PremiumDTO calculate(PolicyDTO policyDTO) {
        LOG.info("calculate() called");

        if (policyDTO == null) {
            LOG.warn("calculate() policyDTO null");
            throw new BadRequestException("policyDTO null");
        }

        Map<Constants.RiskType, List<SubObjectDTO>> groupedSubObjects = groupSubObjects(policyDTO);
        BigDecimal premiumTotal = calculateGroupedSubObjects(groupedSubObjects);

        if (premiumTotal == null) {
            LOG.warn("calculate() result is null");
            throw new PremiumCalculatorServiceException("Can not calculate. Result null");
        }

        PremiumDTO premiumDTO = new PremiumDTO();
        premiumDTO.setId(null);
        premiumDTO.setPremiumSum(premiumTotal.setScale(2, RoundingMode.CEILING).doubleValue());

        return premiumDTO;
    }

    /**
     * Calculates sum insured based on grouped sub objects
     *
     * @param groupedSubObjects - grouped sub objects
     * @return calculated result
     */
    private BigDecimal calculateGroupedSubObjects(Map<Constants.RiskType, List<SubObjectDTO>> groupedSubObjects) {
        LOG.info("calculateGroupedSubObjects() called");

        validateRiskType(groupedSubObjects);

        Map<Constants.RiskType, BigDecimal> groupedSumInsuredTotal = new HashMap<>();

        for (Map.Entry<Constants.RiskType, List<SubObjectDTO>> subObjectsByType : groupedSubObjects.entrySet()) {
            List<SubObjectDTO> value = subObjectsByType.getValue();
            if (value != null) {
                for (SubObjectDTO subObjectDTO : value) {
                    if (groupedSumInsuredTotal.get(subObjectsByType.getKey()) == null) {
                        groupedSumInsuredTotal.put(subObjectsByType.getKey(), BigDecimal.valueOf(subObjectDTO.getSumInsured()));
                    }
                    groupedSumInsuredTotal.get(subObjectsByType.getKey()).plus().add(BigDecimal.valueOf(subObjectDTO.getSumInsured()));
                }
            }
        }

        BigDecimal premiumTotal = null;

        for (Constants.RiskType riskType : Constants.RiskType.values()) {
            BigDecimal riskTypeSumInsured = groupedSumInsuredTotal.get(riskType);
            BigDecimal coefficient = BigDecimal.valueOf(getCoefficientByRiskTypeAndSumInsured(riskType, riskTypeSumInsured));

            if (coefficient == null) {
                LOG.warn("getCoefficientByRiskTypeAndSumInsured() coefficient null");
                throw new PremiumCalculatorServiceException("Coefficient is null");
            }

            if (premiumTotal == null) {
                premiumTotal = riskTypeSumInsured.multiply(coefficient);
            } else {
                premiumTotal = premiumTotal.add(riskTypeSumInsured.multiply(coefficient));
            }
        }

        return premiumTotal;
    }

    /**
     * Gets coefficient for provided params
     *
     * @param riskType           - risk type
     * @param riskTypeSumInsured - risk type sum insured
     * @return coefficient double value
     */
    private Double getCoefficientByRiskTypeAndSumInsured(Constants.RiskType riskType, BigDecimal riskTypeSumInsured) {
        LOG.info("getCoefficientByRiskTypeAndSumInsured() called");

        switch (riskType) {
            case FIRE: {
                if (riskTypeSumInsured.doubleValue() > Constants.PricingPolicy.FIRE_COEFFICIENT_CHANGE_LIMIT) {
                    return Constants.PricingPolicy.FIRE_COEFFICIENT_ABOVE_HUNDRED;
                }
                return Constants.PricingPolicy.FIRE_COEFFICIENT_BELOW_HUNDRED;
            }
            case THEFT: {
                if (riskTypeSumInsured.doubleValue() >= Constants.PricingPolicy.THEFT_COEFFICIENT_CHANGE_LIMIT) {
                    return Constants.PricingPolicy.THEFT_COEFFICIENT_ABOVE_FIFTEEN;
                }
                return Constants.PricingPolicy.THEFT_COEFFICIENT_BELOW_FIFTEEN;
            }
            default:
                return null;
        }
    }

    /**
     * Validates grouped sub objects and removes with not existing risk type
     *
     * @param groupedSubObjects - grouped sub objects
     */
    private void validateRiskType(Map<Constants.RiskType, List<SubObjectDTO>> groupedSubObjects) {
        LOG.info("validateRiskType() called");

        groupedSubObjects.entrySet().removeIf(elem ->
                Arrays.stream(Constants.RiskType.values()).noneMatch(type ->
                        type.equals(elem.getKey())));
    }

    /**
     * Groups sub objects by risk type
     *
     * @param policyDTO - policy DTO entity
     * @return grouped sub objects map
     */
    private Map<Constants.RiskType, List<SubObjectDTO>> groupSubObjects(PolicyDTO policyDTO) {
        LOG.info("groupSubObjects() called");

        Map<Constants.RiskType, List<SubObjectDTO>> groupedSubObjects = new HashMap<>();

        if (policyDTO.getPolicyObjects() != null) {
            for (PolicyObjectDTO policyObjectDTO : policyDTO.getPolicyObjects()) {
                if (policyObjectDTO.getSubObjects() != null) {
                    for (SubObjectDTO subObjectDTO : policyObjectDTO.getSubObjects()) {
                        Constants.RiskType riskType = Constants.RiskType.valueOf(subObjectDTO.getRiskType());

                        if (groupedSubObjects.get(riskType) == null) {
                            groupedSubObjects.put(riskType, new ArrayList<>());
                        }
                        List<SubObjectDTO> subObjectDTOS = groupedSubObjects.get(riskType);
                        subObjectDTOS.add(subObjectDTO);
                    }
                }
            }
        }
        return groupedSubObjects;
    }
}
