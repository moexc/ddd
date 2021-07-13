package cn.moexc.ddd.app.service.impl;

import cn.moexc.ddd.app.cmd.PayCmd;
import cn.moexc.ddd.app.service.ContractService;
import cn.moexc.ddd.domain.aggregate.contract.ContractAR;
import cn.moexc.ddd.domain.aggregate.contract.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public void pay(PayCmd payCmd) {
        ContractAR contract = contractRepository.byId(payCmd.getContractId());
        contract.pay(payCmd.getMoney());
        contractRepository.save(contract);
    }
}
