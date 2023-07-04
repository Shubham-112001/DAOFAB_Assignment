package com.daofab.response;

/*
Author : shubham
*/
public class UserDataResponse extends DaofabResponse{
    private String senderName;
    private String receiverName;
    private long totalAmount;
    private long totalPaidAmount;

    public long getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(long totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

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
}
