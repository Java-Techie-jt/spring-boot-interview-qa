package com.javatechie;

import com.javatechie.config.SecurityConfig;
import com.javatechie.di.OrderService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,AopAutoConfiguration.class})
@SpringBootApplication
public class InterviewQaApplication  implements CommandLineRunner{

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct method called ...");
    }


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
        System.out.println("CommandLineRunner run() method ....... executed");
    }
}
