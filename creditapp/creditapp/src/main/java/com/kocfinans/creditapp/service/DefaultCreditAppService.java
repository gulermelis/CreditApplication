package com.kocfinans.creditapp.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.Builder;

import com.kocfinans.creditapp.client.CreditScore;
import com.kocfinans.creditapp.client.IClient;
import com.kocfinans.creditapp.domain.CustomerInfo;
import com.kocfinans.creditapp.model.AppRequest;
import com.kocfinans.creditapp.model.AppResponse;
import com.kocfinans.creditapp.model.Constants;
import com.kocfinans.creditapp.repository.CreditAppRepository;


public class DefaultCreditAppService implements CreditAppService {

    @Autowired
    private CreditAppRepository repository;

    @Autowired
    private IClient client;

    @Override
    public AppResponse checkApproval(AppRequest request) {
    	
    	
        final BigDecimal creditScore = CreditScore.getCreditScore(request.getIdentityNo());

        //getCreditScore() metodu static oldugu için sınıfın ismiyle eriştik

        final Boolean status = checkCreditAppStatus(creditScore);

      //Builder Pattern
      
        if (!status)  //Kredi Başvurusu reddedildiğinde çalışacak komut bloğu
            return AppResponse.builder()
                    .appResult(false)
                    .message(Constants.CREDIT_APPLICATION_UNSUCCESSFUL_RESPONSE)
                    .build();


        final BigDecimal creditLimit = determineCreditLimit(creditScore, request.getSalary());

        repositoryPersistHandler(request, creditLimit);
        client.sendMessage(request.getPhoneNumber());

        //Builder Pattern
        
        return AppResponse
        		.builder()
                .message(Constants.CREDIT_APPLICATION_SUCCESSFUL_RESPONSE)
                .appResult(true)
                .limit(creditLimit)
                .build();
    }

    public Boolean checkCreditAppStatus(final BigDecimal creditScore) {
        if (creditScore.compareTo(Constants.MIN_CREDIT_SCORE) < 0) //creditScore<500 ise -1 döner
            return Boolean.FALSE;

        return Boolean.TRUE;
    }

    
    public BigDecimal determineCreditLimit(final BigDecimal creditScore, final BigDecimal salary) {
        if (creditScore.compareTo(Constants.MAX_CREDIT_SCORE) < 0)  //creditscore>1000 ise
            return salary.multiply(Constants.creditLimitFactor);  //salary*4


        return salary.multiply(Constants.creditLimitFactor);
    }

    public void repositoryPersistHandler(final AppRequest request, final BigDecimal creditLimit) {

        final CustomerInfo applicant = new CustomerInfo();
        applicant.setIdentityNo(request.getIdentityNo());
        applicant.setSalary(request.getSalary());
        applicant.setName(request.getName());
        applicant.setSurname(request.getSurname());
        applicant.setCreditLimit(creditLimit);
        repository.save(applicant);
    }

    @Override
    public Iterable<CustomerInfo> findAll() {
        return repository.findAll();
    }
    
}