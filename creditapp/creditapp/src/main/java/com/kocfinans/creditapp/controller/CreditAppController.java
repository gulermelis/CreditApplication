package com.kocfinans.creditapp.controller;

import com.kocfinans.creditapp.domain.CustomerInfo;
import com.kocfinans.creditapp.model.AppRequest;
import com.kocfinans.creditapp.service.CreditAppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditAppController {

    @Autowired
    private CreditAppService creditApplicationService;


    @RequestMapping(value = "/v1/creditapplication/approval", method = RequestMethod.POST)
    public ResponseEntity creditApprovalCheck(@RequestBody AppRequest creditApplicationRequest) {
    	
        return ResponseEntity.ok(creditApplicationService.checkApproval(creditApplicationRequest));
    }

    
    
    @GetMapping("/v1/getapplicants")
    Iterable<CustomerInfo> all() {
    	
        return creditApplicationService.findAll();
    }
}
