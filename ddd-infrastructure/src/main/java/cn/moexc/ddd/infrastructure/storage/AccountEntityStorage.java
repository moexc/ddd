package cn.moexc.ddd.infrastructure.storage;

import cn.moexc.ddd.domain.entity.AccountEntity;

public interface AccountEntityStorage {
    int insertSelective(AccountEntity record);

    AccountEntity selectByPrimaryKey(String accountId);

    int updateByPrimaryKeySelective(AccountEntity record);
}
