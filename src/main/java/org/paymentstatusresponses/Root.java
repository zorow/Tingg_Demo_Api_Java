package org.paymentstatusresponses;

import java.util.ArrayList;
import java.util.List;

public class Root {
    private AuthStatus authStatus;
    private List<Result> results = new ArrayList<Result>();
    public AuthStatus getAuthStatus() {
        return authStatus;
    }
    public void setAuthStatus(AuthStatus authStatus) {
        this.authStatus = authStatus;
    }
    public List<Result> getResults() {
        return results;
    }
    public void setResults(List<Result> results) {
        this.results = results;
    }
}