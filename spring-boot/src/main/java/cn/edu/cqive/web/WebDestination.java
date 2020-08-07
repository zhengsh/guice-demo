package cn.edu.cqive.web;

import cn.edu.cqvie.guice.helloworld.MyDestination;
import com.google.inject.Singleton;
import com.google.inject.servlet.RequestScoped;

//@Singleton
@RequestScoped
public class WebDestination implements MyDestination {

    private StringBuilder sb = new StringBuilder();

    public WebDestination() {
        System.out.println("WebDestination");
    }

    public WebDestination(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void write(String s) {
        sb.append(s);
    }

    public String getResult() {
        return sb.toString();
    }
}
