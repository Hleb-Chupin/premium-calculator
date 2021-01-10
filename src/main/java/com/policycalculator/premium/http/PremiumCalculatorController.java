package com.policycalculator.premium.http;

import com.policycalculator.premium.dto.PolicyDTO;
import com.policycalculator.premium.dto.PremiumDTO;
import com.policycalculator.premium.http.exceptions.BadRequestException;
import com.policycalculator.premium.service.PremiumCalculatorService;
import com.policycalculator.premium.service.PremiumCalculatorServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PremiumCalculatorController {

    private static final Logger LOG = LoggerFactory.getLogger(PremiumCalculatorController.class);

    private final PremiumCalculatorService premiumCalculatorService;

    @Autowired
    public PremiumCalculatorController(PremiumCalculatorService premiumCalculatorService) {
        this.premiumCalculatorService = premiumCalculatorService;
    }

    @PostMapping(path = "api/v1.0/premium/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<PremiumDTO> calculatePremium(@RequestBody PolicyDTO policyDTO) {
        LOG.info("calculatePremium({}) POST called by {}", policyDTO);

        try {
            return new ResponseEntity<>(this.premiumCalculatorService.calculate(policyDTO), HttpStatus.OK);
        } catch (PremiumCalculatorServiceException e) {
            LOG.error("calculatePremium() return exception: {}", e);
            throw new BadRequestException(e.getMessage());
        }
    }
}
