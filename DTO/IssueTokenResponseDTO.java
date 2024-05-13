package DTO;

import Models.Token;
import enums.RequestStatus;

public class IssueTokenResponseDTO {

    private Token token = null;

    private RequestStatus requestStatus = null;

    private String failureMessage = "";

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

}
