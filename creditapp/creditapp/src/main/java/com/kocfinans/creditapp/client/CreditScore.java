package com.kocfinans.creditapp.client;

import com.kocfinans.creditapp.exception.IdentityNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CreditScore {

    public static final Map<String, BigDecimal> creditScoreMap = new HashMap<>();


    static {
        creditScoreMap.put("19282190784", BigDecimal.valueOf(400));
        creditScoreMap.put("12314132133", BigDecimal.valueOf(700));
        creditScoreMap.put("12314131311", BigDecimal.valueOf(300));
        creditScoreMap.put("12341414141", BigDecimal.valueOf(1000));
    }

    public static BigDecimal getCreditScore(final String identityNo) {
        if (!creditScoreMap.containsKey(identityNo))
            throw IdentityNotFoundException.create(identityNo);

        return creditScoreMap.get(identityNo);
    }
}
