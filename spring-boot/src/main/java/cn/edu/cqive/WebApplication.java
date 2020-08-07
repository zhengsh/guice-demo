package cn.edu.cqive;


import cn.edu.cqive.filter.SpringAwareGuiceFilter;
import cn.edu.cqive.web.*;
import cn.edu.cqvie.guice.annotaion.Args;
import cn.edu.cqvie.guice.helloworld.MyApplet;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@SpringBootApplication
@ServletComponentScan
public class WebApplication {

    @Bean
    Injector injector(ApplicationContext applicationContext) {
        return Guice.createInjector(new HelloWorldWebModule(), new SpringAwareModule(applicationContext));
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

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}