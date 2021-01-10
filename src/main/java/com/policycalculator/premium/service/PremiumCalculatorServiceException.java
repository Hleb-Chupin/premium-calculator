package com.policycalculator.premium.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PremiumCalculatorServiceException extends RuntimeException {

    private static final Logger LOG = LoggerFactory.getLogger(PremiumCalculatorServiceException.class);

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * @param message The error message
     */
    public PremiumCalculatorServiceException(String message) {
        super(message);
        LOG.info("PremiumCalculatorServiceException {}", message);
    }

    /**
     * Constructor.
     * @param message The error message
     * @param cause The original exception
     */
    public PremiumCalculatorServiceException(String message,
                                  Throwable cause) {
        super(message, cause);
        LOG.info("PremiumCalculatorServiceException {}", message);
    }
}
