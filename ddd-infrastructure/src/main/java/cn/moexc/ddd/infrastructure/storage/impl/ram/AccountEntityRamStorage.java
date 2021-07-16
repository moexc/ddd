package cn.moexc.ddd.infrastructure.storage.impl.ram;

import cn.moexc.ddd.domain.entity.AccountEntity;
import cn.moexc.ddd.infrastructure.config.RamStorageConditional;
import cn.moexc.ddd.infrastructure.storage.AccountEntityStorage;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
@Conditional(RamStorageConditional.class)
public class AccountEntityRamStorage implements AccountEntityStorage {

    private static Map<String, AccountEntity> accountEntityMap = new HashMap<>();

    static {
        AccountEntity entity = new AccountEntity();
        entity.setUserId("1");
        entity.setUserName("moexc");
        entity.setUserPwd("");
        entity.setUserBalance(new BigDecimal("999.99"));
        accountEntityMap.put(entity.getUserId(), entity);
    }

    @Override
    public int insertSelective(AccountEntity record) {
        accountEntityMap.put(record.getUserId(), record);
        return 1;
    }

    @Override
    public AccountEntity selectByPrimaryKey(String accountId) {
        return accountEntityMap.get(accountId);
    }

    @Override
    public int updateByPrimaryKeySelective(AccountEntity record) {
        accountEntityMap.put(record.getUserId(), record);
        return 0;
    }
}
