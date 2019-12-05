package com.example.collecton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Yr
 */

@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication(scanBasePackages = "com")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
