package cn.moexc.ddd.infrastructure.repository;

import cn.moexc.ddd.domain.contract.ContractAR;
import cn.moexc.ddd.domain.contract.ContractRepository;
import cn.moexc.ddd.domain.entity.ContractEntity;
import cn.moexc.ddd.domain.entity.PaymentRecordsEntity;
import cn.moexc.ddd.infrastructure.storage.ContractEntityStorage;
import cn.moexc.ddd.infrastructure.storage.PaymentRecordsEntityStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepositoryImpl implements ContractRepository {

    private final ContractEntityStorage contractEntityStorage;
    private final PaymentRecordsEntityStorage paymentRecordsEntityStorage;

    @Autowired
    public ContractRepositoryImpl(ContractEntityStorage contractEntityStorage, PaymentRecordsEntityStorage paymentRecordsEntityStorage) {
        this.contractEntityStorage = contractEntityStorage;
        this.paymentRecordsEntityStorage = paymentRecordsEntityStorage;
    }

    @Override
    public ContractAR byId(String contractId) {
        ContractEntity contractEntity = contractEntityStorage.selectByPrimaryKey(contractId);
        List<PaymentRecordsEntity> payDetailEntities = paymentRecordsEntityStorage.selectByContractId(contractId);
        return new ContractAR(contractEntity, payDetailEntities);
    }

    @Override
    public void save(ContractAR contractAR) {
        ContractEntity contractEntity = contractAR.getContractEntity();
        contractEntityStorage.updateByPrimaryKeySelective(contractEntity);

        List<PaymentRecordsEntity> recordsEntities = contractAR.getPayDetailEntites();
        recordsEntities.forEach(recordEntity -> {
            if (paymentRecordsEntityStorage.selectByPrimaryKey(recordEntity.getPaymentId()) == null){
                paymentRecordsEntityStorage.insertSelective(recordEntity);
            }else {
                paymentRecordsEntityStorage.updateByPrimaryKeySelective(recordEntity);
            }
        });
    }
}
