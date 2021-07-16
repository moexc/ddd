package cn.moexc.ddd.app.service.impl;

import cn.moexc.ddd.app.cmd.PayCmd;
import cn.moexc.ddd.app.service.ContractService;
import cn.moexc.ddd.domain.contract.ContractAR;
import cn.moexc.ddd.domain.customer.CustomerRepository;
import cn.moexc.ddd.domain.service.ContractDomainService;
import cn.moexc.ddd.domain.contract.ContractRepository;
import cn.moexc.ddd.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository,
                               CustomerRepository customerRepository) {
        this.contractRepository = contractRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pay(PayCmd payCmd) {
        Customer customer = customerRepository.byId(payCmd.getUserId());
        ContractAR contract = contractRepository.byId(payCmd.getContractId());

        ContractDomainService.pay(customer, contract, payCmd.getMoney());

        customerRepository.save(customer);
        contractRepository.save(contract);
    }
}
