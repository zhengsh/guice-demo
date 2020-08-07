package cn.edu.cqive.web;

import com.google.inject.Singleton;
import com.google.inject.servlet.RequestScoped;

//@Singleton
@RequestScoped
public class RequestParams {

    public RequestParams() {
        System.out.println("RequestParams");
    }

    public RequestParams(String greetingName) {
        this.greetingName = greetingName;
    }

    private String greetingName;

    public String getGreetingName() {
        return greetingName;
    }

    public void setGreetingName(String greetingName) {
        this.greetingName = greetingName;
    }
}
