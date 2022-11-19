package org.example;

public class TinggApiModel {

    //required
    private String SERVICE_CODE;
    //required
    public String API_USER_NAME;
    //required
    public String API_USER_PASSWORD;
    //required
    private String ACCOUNT_NUMBER;
    //required
    private String COUNTRY_CODE;
    //required ISO
    private String CURRENCY_CODE;
    private String CUSTOMER_NAME;
    //required 254xxxxxx
    private String MSISDN;
    //required
    private String PAYER_TRANSACTION_ID;
    private String INVOICE_NUMBER;
    private String NARRATION;
    //callback url json
    private String EXTRA_DATA;
    private String PAYMENT_MODE;
    private String HUB_ID;
    //required yyyy-mm-dd hh:mm:ss
    private String DATE_PAYMENT_RECEIVED;
    //required
    private double AMOUNT;

    public TinggApiModel() {
    }

    public String getSERVICE_CODE() {
        return SERVICE_CODE;
    }

    public void setSERVICE_CODE(String SERVICE_CODE) {
        this.SERVICE_CODE = SERVICE_CODE;
    }

    public String getAPI_USER_NAME() {
        return API_USER_NAME;
    }

    public void setAPI_USER_NAME(String API_USER_NAME) {
        this.API_USER_NAME = API_USER_NAME;
    }

    public String getAPI_USER_PASSWORD() {
        return API_USER_PASSWORD;
    }

    public void setAPI_USER_PASSWORD(String API_USER_PASSWORD) {
        this.API_USER_PASSWORD = API_USER_PASSWORD;
    }

    public String getACCOUNT_NUMBER() {
        return ACCOUNT_NUMBER;
    }

    public void setACCOUNT_NUMBER(String ACCOUNT_NUMBER) {
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
    }

    public String getCOUNTRY_CODE() {
        return COUNTRY_CODE;
    }

    public void setCOUNTRY_CODE(String COUNTRY_CODE) {
        this.COUNTRY_CODE = COUNTRY_CODE;
    }

    public String getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    public void setCURRENCY_CODE(String CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    public String getCUSTOMER_NAME() {
        return CUSTOMER_NAME;
    }

    public void setCUSTOMER_NAME(String CUSTOMER_NAME) {
        this.CUSTOMER_NAME = CUSTOMER_NAME;
    }

    public String getMSISDN() {
        return MSISDN;
    }

    public void setMSISDN(String MSISDN) {
        this.MSISDN = MSISDN;
    }

    public String getPAYER_TRANSACTION_ID() {
        return PAYER_TRANSACTION_ID;
    }

    public void setPAYER_TRANSACTION_ID(String PAYER_TRANSACTION_ID) {
        this.PAYER_TRANSACTION_ID = PAYER_TRANSACTION_ID;
    }

    public String getINVOICE_NUMBER() {
        return INVOICE_NUMBER;
    }

    public void setINVOICE_NUMBER(String INVOICE_NUMBER) {
        this.INVOICE_NUMBER = INVOICE_NUMBER;
    }

    public String getNARRATION() {
        return NARRATION;
    }

    public void setNARRATION(String NARRATION) {
        this.NARRATION = NARRATION;
    }

    public String getEXTRA_DATA() {
        return EXTRA_DATA;
    }

    public void setEXTRA_DATA(String EXTRA_DATA) {
        this.EXTRA_DATA = EXTRA_DATA;
    }

    public String getPAYMENT_MODE() {
        return PAYMENT_MODE;
    }

    public void setPAYMENT_MODE(String PAYMENT_MODE) {
        this.PAYMENT_MODE = PAYMENT_MODE;
    }

    public String getHUB_ID() {
        return HUB_ID;
    }

    public void setHUB_ID(String HUB_ID) {
        this.HUB_ID = HUB_ID;
    }

    public String getDATE_PAYMENT_RECEIVED() {
        return DATE_PAYMENT_RECEIVED;
    }

    public void setDATE_PAYMENT_RECEIVED(String DATE_PAYMENT_RECEIVED) {
        this.DATE_PAYMENT_RECEIVED = DATE_PAYMENT_RECEIVED;
    }

    public double getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(double AMOUNT) {
        this.AMOUNT = AMOUNT;
    }
}
