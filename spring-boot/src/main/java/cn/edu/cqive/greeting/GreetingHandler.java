package cn.edu.cqive.greeting;

import cn.edu.cqvie.guice.helloworld.MyApplet;
import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class GreetingHandler {

    private final MyApplet applet;
    private final WebDestination webDestination;
    private final RequestParams requestParams;

    @Inject
    public GreetingHandler(MyApplet applet, WebDestination webDestination, RequestParams requestParams) {
        this.applet = applet;
        this.webDestination = webDestination;
        this.requestParams = requestParams;
    }

    public String getByName(String name) {
        requestParams.setGreetingName(name);
        applet.run();
        return webDestination.getResult();
    }
}
