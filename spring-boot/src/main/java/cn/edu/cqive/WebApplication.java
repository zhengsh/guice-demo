package cn.edu.cqive;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebApplication {


    @GetMapping("/hello")
    public String index(@RequestParam("msg") String msg) {
        return "Greetings from Spring Boot! =>" + msg;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}