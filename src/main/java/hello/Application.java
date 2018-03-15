package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {

        MsSqlConnection.connect(); //It's a method for testing DB calls
        SpringApplication.run(Application.class, args);
    }
}
