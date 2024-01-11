package com.javatechie.config;

import com.javatechie.dto.KafkaProps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class KafkaConfig {

    @Bean
    @Profile("dev")
    public KafkaProps devKafkaProps() {
        KafkaProps props = new KafkaProps("2.237.64.90:8181", 8181, "dev-user-topic");
        System.out.println("dev bean initialized !");
        return props;
    }

    @Bean
    @Profile("stg")
    public KafkaProps stgKafkaProps() {
        KafkaProps props = new KafkaProps("200.40.7.181:8282", 8282, "stg-user-topic");
        System.out.println("stg bean initialized !");
        return props;
    }

    @Bean
    @Profile("prod")
    public KafkaProps prodKafkaProps() {
        KafkaProps props = new KafkaProps("247.69.84.118:8383", 8383, "prod-user-topic");
        System.out.println("prod bean initialized !");
        return props;
    }
}
