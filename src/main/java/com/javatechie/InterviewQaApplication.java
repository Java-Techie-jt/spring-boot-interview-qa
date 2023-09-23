package com.javatechie;

import com.javatechie.common.MailConfig;
import com.javatechie.config.SecurityConfig;
import com.javatechie.di.OrderService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,AopAutoConfiguration.class})
@SpringBootApplication
public class InterviewQaApplication implements CommandLineRunner {

    //    @Value("${offer.discount.price}")
//    private int discountValue;
    @Autowired
    private Environment environment;
//    @Value("${spring.profiles.active}")
//    private String activeProfile;

    @Autowired
    private MailConfig mailConfig;


    public static void main(String[] args) {
        //ConfigurableApplicationContext context =
        System.out.println("SpringApplication run() method ....... executed");
        SpringApplication.run(InterviewQaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //DB connection
        //populate some data to the db
        // pre processing logic you want to perform
        System.out.println("**************" + environment.getProperty("offer.discount.price"));
       // System.out.println("PROFILE : " + activeProfile);
        System.out.println(mailConfig);
        System.out.println("CommandLineRunner run() method ....... executed");
    }
}
