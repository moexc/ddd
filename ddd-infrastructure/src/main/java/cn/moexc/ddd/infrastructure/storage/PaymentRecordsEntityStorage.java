package cn.moexc.ddd.infrastructure.storage;

import cn.moexc.ddd.domain.entity.PaymentRecordsEntity;

import java.util.List;

public interface PaymentRecordsEntityStorage {
    int insertSelective(PaymentRecordsEntity record);

    PaymentRecordsEntity selectByPrimaryKey(String recordId);

    int updateByPrimaryKeySelective(PaymentRecordsEntity record);

    List<PaymentRecordsEntity> selectByContractId(String contractId);
}
