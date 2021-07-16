package cn.moexc.ddd.infrastructure.storage.impl.oracle;

import cn.moexc.ddd.domain.entity.AccountEntity;
import cn.moexc.ddd.infrastructure.config.OracleStorageConditional;
import cn.moexc.ddd.infrastructure.dao.AccountEntityMapper;
import cn.moexc.ddd.infrastructure.storage.AccountEntityStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(OracleStorageConditional.class)
public class AccountEntityOracleStorage implements AccountEntityStorage {

    private final AccountEntityMapper accountEntityMapper;

    @Autowired
    public AccountEntityOracleStorage(AccountEntityMapper accountEntityMapper) {
        this.accountEntityMapper = accountEntityMapper;
    }

    @Override
    public int insertSelective(AccountEntity record) {
        return accountEntityMapper.insertSelective(record);
    }

    @Override
    public AccountEntity selectByPrimaryKey(String accountId) {
        return accountEntityMapper.selectByPrimaryKey(accountId);
    }

    @Override
    public int updateByPrimaryKeySelective(AccountEntity record) {
        return accountEntityMapper.updateByPrimaryKeySelective(record);
    }
}
