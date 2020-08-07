package cn.edu.cqive.web;

import cn.edu.cqive.dao.SampleDao;
import cn.edu.cqvie.guice.helloworld.MyDestination;
import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

//@Singleton
@RequestScoped
public class WebDestination implements MyDestination {

    private final StringBuilder sb = new StringBuilder();


    public String getResult() {
        return sb.toString();
    }

    @Override
    public void write(java.lang.String s) {
        sb.append(s);
    }
}
