package cn.moexc.ddd.infrastructure.storage.impl.oracle;

import cn.moexc.ddd.domain.entity.PaymentRecordsEntity;
import cn.moexc.ddd.infrastructure.config.OracleStorageConditional;
import cn.moexc.ddd.infrastructure.dao.PaymentRecordsEntityMapper;
import cn.moexc.ddd.infrastructure.storage.PaymentRecordsEntityStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Conditional(OracleStorageConditional.class)
public class PaymentRecordsEntityOracleStorage implements PaymentRecordsEntityStorage {

    private final PaymentRecordsEntityMapper paymentRecordsEntityMapper;

    @Autowired
    public PaymentRecordsEntityOracleStorage(PaymentRecordsEntityMapper paymentRecordsEntityMapper) {
        this.paymentRecordsEntityMapper = paymentRecordsEntityMapper;
    }

    @Override
    public int insertSelective(PaymentRecordsEntity record) {
        return paymentRecordsEntityMapper.insertSelective(record);
    }

    @Override
    public PaymentRecordsEntity selectByPrimaryKey(String recordId) {
        return paymentRecordsEntityMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByPrimaryKeySelective(PaymentRecordsEntity record) {
        return paymentRecordsEntityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<PaymentRecordsEntity> selectByContractId(String contractId) {
        return paymentRecordsEntityMapper.selectByContractId(contractId);
    }
}
