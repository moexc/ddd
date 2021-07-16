package cn.moexc.ddd.domain.customer;

import cn.moexc.ddd.domain.contract.PayException;
import cn.moexc.ddd.domain.entity.AccountEntity;

import java.math.BigDecimal;

public class Customer{
    /**
     * ID
     */
    private String customerId;

    /**
     * 名称
     */
    private String customerName;

    /**
     * 余额
     */
    private BigDecimal balance;

    public Customer(AccountEntity entity) {
        this.customerId = entity.getUserId();
        this.customerName = entity.getUserName();
        this.balance = entity.getUserBalance();
    }

    public AccountEntity getEntity(){
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUserId(this.customerId);
        accountEntity.setUserName(this.customerName);
        accountEntity.setUserBalance(this.balance);
        return accountEntity;
    }

    public void pay(BigDecimal money){
        if (money.compareTo(BigDecimal.ZERO) <= 0){
            throw new PayException("付款金额需大于0");
        }
        if (this.balance.compareTo(money) < 0){
            throw new PayException("账户余额不足");
        }
        this.balance = this.balance.subtract(money);
    }

}
