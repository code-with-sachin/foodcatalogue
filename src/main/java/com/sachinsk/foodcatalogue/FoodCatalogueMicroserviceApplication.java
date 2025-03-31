package com.sachinsk.foodcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FoodCatalogueMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodCatalogueMicroserviceApplication.class, args);
    }

    @Bean
    @LoadBalanced   //Since there can be multiple instance of Restaurant-Listing Microservice -> Now it's the task of Eureka to find the instance i.e. NOT so Busy OR is available to quickly respond to our request( So go to that particular instance & fetch the requested restaurant details)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
