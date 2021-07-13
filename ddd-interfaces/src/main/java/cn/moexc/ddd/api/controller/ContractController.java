package cn.moexc.ddd.api.controller;

import cn.moexc.ddd.app.cmd.PayCmd;
import cn.moexc.ddd.app.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract")
public class ContractController {

    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping("/pay")
    public void pay(@RequestBody PayCmd payCmd){
        contractService.pay(payCmd);
    }

}
