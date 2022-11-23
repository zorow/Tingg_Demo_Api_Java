package org.paymentstatusrequests;

public class Packet{
    public String payerTransactionID;
    public String beepTransactionID;

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
