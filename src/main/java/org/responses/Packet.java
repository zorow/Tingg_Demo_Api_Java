package org.responses;

public class Packet {
    private String statusCode;
    private String statusDescription;
    private String payerTransactionID;
    private String beepTransactionID;
    private String receiptNumber;
    private String receiverNarration;
    private String function;
    private String msisdn;
    private String serviceCode;
    private String paymentDate;
    private String clientCode;
    private String extraData;
    public String getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(String statusCode) {
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
    public String getFunction() {
        return function;
    }
    public void setFunction(String function) {
        this.function = function;
    }
    public String getMsisdn() {
        return msisdn;
    }
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
    public String getServiceCode() {
        return serviceCode;
    }
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
    public String getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    public String getClientCode() {
        return clientCode;
    }
    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }
    public String getExtraData() {
        return extraData;
    }
    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }
}