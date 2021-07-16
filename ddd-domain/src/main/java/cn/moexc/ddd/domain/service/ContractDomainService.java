package cn.moexc.ddd.domain.service;

import cn.moexc.ddd.domain.contract.ContractAR;
import cn.moexc.ddd.domain.customer.Customer;

import java.math.BigDecimal;

public final class ContractDomainService {
    public static void pay(Customer customer, ContractAR contrad, BigDecimal money){
        customer.pay(money);
        contrad.pay(money);
    }
}
