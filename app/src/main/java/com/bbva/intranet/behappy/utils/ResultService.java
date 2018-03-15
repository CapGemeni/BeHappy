package com.bbva.intranet.behappy.utils;

import com.bbva.intranet.behappy.models.User;

/**
 * Created by gesformexico on 22/02/18.
 */

public class ResultService {
    public String Response;
    public Exception Exception;
    public Object data;
    public String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public java.lang.Exception getException() {
        return Exception;
    }

    public void setException(java.lang.Exception exception) {
        Exception = exception;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultService(String response, java.lang.Exception exception, Object data) {
        Response = response;
        Exception = exception;
        this.data = data;
    }

    public ResultService() {
        this.Response = null;
        this.Exception = null;
    }

    public ResultService(String response, Exception exception) {
        this.Response = response;
        this.Exception = exception;
    }
}
