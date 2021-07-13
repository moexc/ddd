package cn.moexc.ddd.infrastructure.dao;

import cn.moexc.ddd.domain.entity.ContractEntity;

public interface ContractEntityMapper {
    int deleteByPrimaryKey(String contractId);

    int insert(ContractEntity record);

    int insertSelective(ContractEntity record);

    ContractEntity selectByPrimaryKey(String contractId);

    int updateByPrimaryKeySelective(ContractEntity record);

    int updateByPrimaryKey(ContractEntity record);
}