package com.daofab.model;

import jakarta.persistence.Entity;

/*
Author : shubham
*/
@Entity
public class TransactionData extends Daofab{
    private long userDataId;
    private long paidAmount;

    public long getUserDataId() {
        return userDataId;
    }

    public void setUserDataId(long userDataId) {
        this.userDataId = userDataId;
    }

    public long getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(long paidAmount) {
        this.paidAmount = paidAmount;
    }
}
