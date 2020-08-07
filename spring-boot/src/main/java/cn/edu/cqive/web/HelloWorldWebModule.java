package cn.edu.cqive.web;

import cn.edu.cqvie.guice.helloworld.*;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

/**
 * @author ZAKJ_ASUS
 */
public class HelloWorldWebModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ServletModule());
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(WebDestination.class);
    }

    @Provides
    @Output
    String getOutputString(RequestParams requestParam) {
        return requestParam.getMessage();
    }
}
