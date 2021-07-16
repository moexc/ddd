package cn.moexc.ddd.infrastructure.storage.impl.oracle;

import cn.moexc.ddd.domain.entity.ContractEntity;
import cn.moexc.ddd.infrastructure.config.OracleStorageConditional;
import cn.moexc.ddd.infrastructure.dao.ContractEntityMapper;
import cn.moexc.ddd.infrastructure.storage.ContractEntityStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(OracleStorageConditional.class)
public class ContractEntityOracleStorage implements ContractEntityStorage {

    private final ContractEntityMapper contractEntityMapper;

    @Autowired
    public ContractEntityOracleStorage(ContractEntityMapper contractEntityMapper) {
        this.contractEntityMapper = contractEntityMapper;
    }

    @Override
    public int insertSelective(ContractEntity record) {
        return contractEntityMapper.insertSelective(record);
    }

    @Override
    public ContractEntity selectByPrimaryKey(String contractId) {
        return contractEntityMapper.selectByPrimaryKey(contractId);
    }

    @Override
    public int updateByPrimaryKeySelective(ContractEntity record) {
        return contractEntityMapper.updateByPrimaryKeySelective(record);
    }
}
