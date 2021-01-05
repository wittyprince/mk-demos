package com.mk.demos.spring.ioc.container.overview.domain;

/**
 * 账户类
 *
 * @author WangChen
 * Created on 2021/1/2 19:21
 * @since 1.0
 */
public class Account {
    public Account() {
        System.out.println("I am account constructor...");
    }

    private Long id;
    private Long userId;
    private String accountNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountNo='" + accountNo + '\'' +
                '}';
    }
}
