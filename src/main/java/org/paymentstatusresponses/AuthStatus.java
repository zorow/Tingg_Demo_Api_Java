package org.paymentstatusresponses;

public class AuthStatus {
    private Integer authStatusCode;
    private String authStatusDescription;
    public Integer getAuthStatusCode() {
        return authStatusCode;
    }
    public void setAuthStatusCode(Integer authStatusCode) {
        this.authStatusCode = authStatusCode;
    }
    public String getAuthStatusDescription() {
        return authStatusDescription;
    }
    public void setAuthStatusDescription(String authStatusDescription) {
        this.authStatusDescription = authStatusDescription;
    }
}