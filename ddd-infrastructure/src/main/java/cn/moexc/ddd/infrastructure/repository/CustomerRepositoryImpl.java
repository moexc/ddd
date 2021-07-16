package cn.moexc.ddd.infrastructure.repository;

import cn.moexc.ddd.domain.customer.Customer;
import cn.moexc.ddd.domain.customer.CustomerRepository;
import cn.moexc.ddd.domain.entity.AccountEntity;
import cn.moexc.ddd.infrastructure.dao.AccountEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final AccountEntityMapper accountEntityMapper;

    @Autowired
    public CustomerRepositoryImpl(AccountEntityMapper accountEntityMapper) {
        this.accountEntityMapper = accountEntityMapper;
    }

    @Override
    public Customer byId(String id) {
        AccountEntity accountEntity = accountEntityMapper.selectByPrimaryKey(id);
        return new Customer(accountEntity);
    }

    @Override
    public void save(Customer customer) {
        AccountEntity entity = customer.getEntity();
        accountEntityMapper.updateByPrimaryKeySelective(entity);
    }
}
