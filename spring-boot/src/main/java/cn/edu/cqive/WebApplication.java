package cn.edu.cqive;


import cn.edu.cqive.filter.SpringAwareGuiceFilter;
import cn.edu.cqive.web.HelloWorldWebModule;
import cn.edu.cqive.web.RequestParams;
import cn.edu.cqive.web.WebDestination;
import cn.edu.cqvie.guice.helloworld.MyApplet;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
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
    Injector injector() {
        return Guice.createInjector(new HelloWorldWebModule());
    }

    @Bean @RequestScope
    MyApplet applet(Injector injector) {
        return injector.getInstance(MyApplet.class);
    }

    @Bean @RequestScope
    WebDestination destination(Injector injector) {
        return injector.getInstance(WebDestination.class);
    }

    @Bean @RequestScope
    RequestParams params(Injector injector) {
        return injector.getInstance(RequestParams.class);
    }

    @Autowired MyApplet applet;
    @Autowired WebDestination webDestination;
    @Autowired RequestParams requestParams;

    @GetMapping("/hello")
    public String home(@RequestParam("msg") String msg) {
        //return "Greetings from Spring Boot! =>" + msg;
        requestParams.setMessage(msg);
        applet.run();
        return webDestination.getResult();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}