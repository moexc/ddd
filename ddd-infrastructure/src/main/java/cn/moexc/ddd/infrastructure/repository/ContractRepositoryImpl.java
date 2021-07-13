package cn.moexc.ddd.infrastructure.repository;

import cn.moexc.ddd.domain.aggregate.contract.ContractAR;
import cn.moexc.ddd.domain.aggregate.contract.ContractRepository;
import cn.moexc.ddd.domain.entity.ContractEntity;
import cn.moexc.ddd.domain.entity.PaymentRecordsEntity;
import cn.moexc.ddd.infrastructure.dao.ContractEntityMapper;
import cn.moexc.ddd.infrastructure.dao.PaymentRecordsEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepositoryImpl implements ContractRepository {

    private final ContractEntityMapper contractEntityMapper;
    private final PaymentRecordsEntityMapper paymentRecordsEntityMapper;

    @Autowired
    public ContractRepositoryImpl(ContractEntityMapper contractEntityMapper, PaymentRecordsEntityMapper paymentRecordsEntityMapper) {
        this.contractEntityMapper = contractEntityMapper;
        this.paymentRecordsEntityMapper = paymentRecordsEntityMapper;
    }

    @Override
    public ContractAR byId(String contractId) {
        ContractEntity contractEntity = contractEntityMapper.selectByPrimaryKey(contractId);
        List<PaymentRecordsEntity> payDetailEntities = paymentRecordsEntityMapper.selectByContractId(contractId);
        return new ContractAR(contractEntity, payDetailEntities);
    }

    @Override
    public void save(ContractAR contractAR) {
        ContractEntity contractEntity = contractAR.getContractEntity();
        contractEntityMapper.updateByPrimaryKeySelective(contractEntity);

        List<PaymentRecordsEntity> recordsEntities = contractAR.getPayDetailEntites();
        recordsEntities.forEach(recordEntity -> {
            if (paymentRecordsEntityMapper.selectByPrimaryKey(recordEntity.getPaymentId()) == null){
                paymentRecordsEntityMapper.insertSelective(recordEntity);
            }else {
                paymentRecordsEntityMapper.updateByPrimaryKeySelective(recordEntity);
            }
        });
    }
}
