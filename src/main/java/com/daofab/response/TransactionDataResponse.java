package com.daofab.response;

/*
Author : shubham
*/
public class TransactionDataResponse extends DaofabResponse{
    private long userDataId;
    private long paidAmount;
    private String senderName;
    private String receiverName;
    private long totalAmount;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

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
