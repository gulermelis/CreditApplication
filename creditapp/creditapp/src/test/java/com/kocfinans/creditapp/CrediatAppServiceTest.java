package com.kocfinans.creditapp;

import com.kocfinans.creditapp.exception.IdentityNotFoundException;
import com.kocfinans.creditapp.model.Constants;
import com.kocfinans.creditapp.service.DefaultCreditAppService;

import lombok.Builder;

import com.kocfinans.creditapp.model.AppRequest;
import com.kocfinans.creditapp.model.AppResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreditAppServiceTest {

    private DefaultCreditAppService creditApplicationService;


    @Test
    public void testCheckCreditApplicationApprovalThrowsCorrectException(){

        creditApplicationService = new DefaultCreditAppService();

        final AppRequest request = new AppRequest();
        request.setIdentityNo("131313131");
        request.setSalary(BigDecimal.valueOf(1000));
        request.setName("charles");
        request.setPhoneNumber("54874131");
        request.setSurname("bukowski");

      
        final AppResponse expectedResult = AppResponse.builder()
                .appResult(Boolean.FALSE)
                .message(Constants.CREDIT_APPLICATION_UNSUCCESSFUL_RESPONSE)
                .build();

        IdentityNotFoundException thrown =
                assertThrows(IdentityNotFoundException.class,
                        () -> creditApplicationService.checkApproval(request));

    }

    @Test
    public void testCheckCreditApplicationApprovalReturnUnsuccessfulCreditResponse(){
        creditApplicationService = new DefaultCreditAppService();

        final AppRequest request = new AppRequest();
        request.setIdentityNo("19282190784");
        request.setSalary(BigDecimal.valueOf(10));
        request.setName("Hasan");
        request.setPhoneNumber("213131313");
        request.setSurname("Ucar");

        final AppResponse expectedResult = AppResponse.builder()
                .appResult(Boolean.FALSE)
                .message(Constants.CREDIT_APPLICATION_UNSUCCESSFUL_RESPONSE)
                .build();

        final AppResponse result = creditApplicationService.checkApproval(request);

        assertThat(result.getAppResult(),is(equalTo(expectedResult.getAppResult())));
        assertThat(result.getLimit(),is(equalTo(expectedResult.getLimit())));
        assertThat(result.getMessage(),is(equalTo(expectedResult.getMessage())));
    }



}
