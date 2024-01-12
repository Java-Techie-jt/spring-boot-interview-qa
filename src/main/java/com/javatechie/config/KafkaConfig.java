package com.javatechie.config;

import com.javatechie.dto.KafkaProps;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class KafkaConfig {

    @Bean
    //@Profile("dev")
    @ConditionalOnProperty(prefix = "app.active",name = "env",havingValue = "dev")
    public KafkaProps devKafkaProps() {
        KafkaProps props = new KafkaProps("2.237.64.90:8181", 8181, "dev-user-topic");
        System.out.println("kafka dev bean initialized !");
        return props;
    }

    @Bean
   // @Profile("stg")
    @ConditionalOnProperty(prefix = "app.active",name = "env",havingValue = "stg")
    public KafkaProps stgKafkaProps() {
        KafkaProps props = new KafkaProps("200.40.7.181:8282", 8282, "stg-user-topic");
        System.out.println("kafka stg bean initialized !");
        return props;
    }

    @Bean
    //@Profile("prod")
    @ConditionalOnProperty(prefix = "app.active",name = "env",havingValue = "prod")
    public KafkaProps prodKafkaProps() {
        KafkaProps props = new KafkaProps("247.69.84.118:8383", 8383, "prod-user-topic");
        System.out.println("kafka prod bean initialized !");
        return props;
    }
}
