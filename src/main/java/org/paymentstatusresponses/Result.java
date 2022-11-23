package org.paymentstatusresponses;

public class Result {
    private Integer statusCode;
    private String statusDescription;
    private String payerTransactionID;
    private String beepTransactionID;
    private String mSISDN;
    private String payerClientCode;
    private String receiptNumber;
    private String receiverNarration;
    private Integer totalRecordsPendingQuery;
    private Integer totalRecordsPendingAck;
    private String paymentExtraData;
    public Integer getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
    public String getStatusDescription() {
        return statusDescription;
    }
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
    public String getPayerTransactionID() {
        return payerTransactionID;
    }
    public void setPayerTransactionID(String payerTransactionID) {
        this.payerTransactionID = payerTransactionID;
    }
    public String getBeepTransactionID() {
        return beepTransactionID;
    }
    public void setBeepTransactionID(String beepTransactionID) {
        this.beepTransactionID = beepTransactionID;
    }
    public String getMSISDN() {
        return mSISDN;
    }
    public void setMSISDN(String mSISDN) {
        this.mSISDN = mSISDN;
    }
    public String getPayerClientCode() {
        return payerClientCode;
    }
    public void setPayerClientCode(String payerClientCode) {
        this.payerClientCode = payerClientCode;
    }
    public String getReceiptNumber() {
        return receiptNumber;
    }
    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }
    public String getReceiverNarration() {
        return receiverNarration;
    }
    public void setReceiverNarration(String receiverNarration) {
        this.receiverNarration = receiverNarration;
    }
    public Integer getTotalRecordsPendingQuery() {
        return totalRecordsPendingQuery;
    }
    public void setTotalRecordsPendingQuery(Integer totalRecordsPendingQuery) {
        this.totalRecordsPendingQuery = totalRecordsPendingQuery;
    }
    public Integer getTotalRecordsPendingAck() {
        return totalRecordsPendingAck;
    }
    public void setTotalRecordsPendingAck(Integer totalRecordsPendingAck) {
        this.totalRecordsPendingAck = totalRecordsPendingAck;
    }
    public String getPaymentExtraData() {
        return paymentExtraData;
    }
    public void setPaymentExtraData(String paymentExtraData) {
        this.paymentExtraData = paymentExtraData;
    }
}