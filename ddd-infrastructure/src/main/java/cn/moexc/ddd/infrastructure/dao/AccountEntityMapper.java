package cn.moexc.ddd.infrastructure.dao;

import cn.moexc.ddd.domain.entity.AccountEntity;

public interface AccountEntityMapper {
    int deleteByPrimaryKey(String userId);

    int insert(AccountEntity record);

    int insertSelective(AccountEntity record);

    AccountEntity selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(AccountEntity record);

    int updateByPrimaryKey(AccountEntity record);
}