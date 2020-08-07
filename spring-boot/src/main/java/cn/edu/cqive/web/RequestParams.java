package cn.edu.cqive.web;

import com.google.inject.Singleton;
import com.google.inject.servlet.RequestScoped;

//@Singleton
@RequestScoped
public class RequestParams {

    public RequestParams() {
        System.out.println("RequestParams");
    }

    public RequestParams(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
