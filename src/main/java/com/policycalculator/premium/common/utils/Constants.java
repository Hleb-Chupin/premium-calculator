package com.policycalculator.premium.common.utils;

public class Constants {

    public enum RiskType {
        FIRE, THEFT
    }

    // Policy status
    public static String REGISTERED = "REGISTERED";
    public static String APPROVED = "APPROVED";

    public static abstract class PricingPolicy {

        // Fire coefficient
        public static final double FIRE_COEFFICIENT_BELOW_HUNDRED = 0.014;
        public static final double FIRE_COEFFICIENT_ABOVE_HUNDRED = 0.024;
        public static final int FIRE_COEFFICIENT_CHANGE_LIMIT = 100;

        // Theft coefficient
        public static final double THEFT_COEFFICIENT_BELOW_FIFTEEN = 0.11;
        public static final double THEFT_COEFFICIENT_ABOVE_FIFTEEN = 0.05;
        public static final int THEFT_COEFFICIENT_CHANGE_LIMIT = 15;
    }
}
