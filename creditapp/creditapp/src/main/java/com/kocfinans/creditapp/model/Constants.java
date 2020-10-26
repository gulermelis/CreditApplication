package com.kocfinans.creditapp.model;

import java.math.BigDecimal;

public final class Constants {

	public static BigDecimal creditLimitFactor = BigDecimal.valueOf(4);
    public static BigDecimal MIN_CREDIT_SCORE = BigDecimal.valueOf(500);
    public static BigDecimal MAX_CREDIT_SCORE = BigDecimal.valueOf(1000);
    public static String CREDIT_APPLICATION_UNSUCCESSFUL_RESPONSE = "Your credit application did not turn out to be positive.";
    public static String CREDIT_APPLICATION_SUCCESSFUL_RESPONSE = "Your credit application turn out to be positive.";
}