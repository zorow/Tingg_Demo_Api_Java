package org.example;

public class Result {
    private Integer statusCode;
    private String statusDescription;
    private String payerTransactionID;
    private String beepTransactionID;
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
}