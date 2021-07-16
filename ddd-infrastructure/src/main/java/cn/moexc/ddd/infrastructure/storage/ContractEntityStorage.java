package cn.moexc.ddd.infrastructure.storage;

import cn.moexc.ddd.domain.entity.ContractEntity;

public interface ContractEntityStorage {
    int insertSelective(ContractEntity record);

    ContractEntity selectByPrimaryKey(String contractId);

    int updateByPrimaryKeySelective(ContractEntity record);
}
