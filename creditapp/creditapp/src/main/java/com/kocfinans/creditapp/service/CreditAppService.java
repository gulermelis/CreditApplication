package com.kocfinans.creditapp.service;

import com.kocfinans.creditapp.domain.CustomerInfo;
import com.kocfinans.creditapp.model.AppRequest;
import com.kocfinans.creditapp.model.AppResponse;

public interface CreditAppService {

    AppResponse checkApproval(final AppRequest request);

    Iterable<CustomerInfo> findAll();
}
