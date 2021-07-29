package com.mk.demos.mapstruct.customer;

/**
 * @author WangChen
 * Created on 2021/7/29 16:10
 * @since
 */
public class CustomerDto {

    private Record record;
    private Account account;

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
