package cn.moexc.ddd.infrastructure.repository;

import cn.moexc.ddd.domain.customer.Customer;
import cn.moexc.ddd.domain.customer.CustomerRepository;
import cn.moexc.ddd.domain.entity.AccountEntity;
import cn.moexc.ddd.infrastructure.storage.AccountEntityStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final AccountEntityStorage accountEntityStorage;

    @Autowired
    public CustomerRepositoryImpl(AccountEntityStorage accountEntityStorage) {
        this.accountEntityStorage = accountEntityStorage;
    }

    @Override
    public Customer byId(String id) {
        AccountEntity accountEntity = accountEntityStorage.selectByPrimaryKey(id);
        return new Customer(accountEntity);
    }

    @Override
    public void save(Customer customer) {
        AccountEntity entity = customer.getEntity();
        accountEntityStorage.updateByPrimaryKeySelective(entity);
    }
}
