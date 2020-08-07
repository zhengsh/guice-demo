package cn.edu.cqive.controller;

import cn.edu.cqive.greeting.GreetingHandler;
import cn.edu.cqive.greeting.HelloWorldWebModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author ZAKJ_ASUS
 */
@RestController
public class SampleController {

    @Bean
    Injector injector(ApplicationContext applicationContext) {
        return Guice.createInjector(new HelloWorldWebModule(), new SpringAwareServletModule(applicationContext));
    }

    @Bean @RequestScope
    GreetingHandler getRequestParams(Injector injector) {
        return injector.getInstance(GreetingHandler.class);
    }

    @Autowired
    GreetingHandler greetingHandler;

    @GetMapping("/greeting")
    public String greeting(@RequestParam("name") String name) {
        return greetingHandler.getByName(name);
    }
}
