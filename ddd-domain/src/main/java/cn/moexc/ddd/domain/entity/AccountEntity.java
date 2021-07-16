package cn.moexc.ddd.domain.entity;

import java.math.BigDecimal;

/**
    * 账户
    */
public class AccountEntity {
    /**
    * 用户ID
    */
    private String userId;

    /**
    * 用户名称
    */
    private String userName;

    /**
    * 密码
    */
    private String userPwd;

    /**
    * 余额
    */
    private BigDecimal userBalance;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public BigDecimal getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(BigDecimal userBalance) {
        this.userBalance = userBalance;
    }
}