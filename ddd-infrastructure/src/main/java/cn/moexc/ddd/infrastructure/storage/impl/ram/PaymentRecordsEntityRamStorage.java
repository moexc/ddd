package cn.moexc.ddd.infrastructure.storage.impl.ram;

import cn.moexc.ddd.domain.entity.PaymentRecordsEntity;
import cn.moexc.ddd.infrastructure.config.RamStorageConditional;
import cn.moexc.ddd.infrastructure.storage.PaymentRecordsEntityStorage;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Conditional(RamStorageConditional.class)
public class PaymentRecordsEntityRamStorage implements PaymentRecordsEntityStorage {

    private static Map<String, PaymentRecordsEntity> paymentRecordsEntityMap = new HashMap<>();

    @Override
    public int insertSelective(PaymentRecordsEntity record) {
        paymentRecordsEntityMap.put(record.getPaymentId(), record);
        return 1;
    }

    @Override
    public PaymentRecordsEntity selectByPrimaryKey(String recordId) {
        return paymentRecordsEntityMap.get(recordId);
    }

    @Override
    public int updateByPrimaryKeySelective(PaymentRecordsEntity record) {
        paymentRecordsEntityMap.put(record.getPaymentId(), record);
        return 1;
    }

    @Override
    public List<PaymentRecordsEntity> selectByContractId(String contractId) {
        List<PaymentRecordsEntity> recordsEntities = new ArrayList<>();
        paymentRecordsEntityMap.forEach((s, recordsEntity) -> {
            if (recordsEntity.getPaymentNumber().equals(contractId)){
                recordsEntities.add(recordsEntity);
            }
        });
        return recordsEntities;
    }
}
