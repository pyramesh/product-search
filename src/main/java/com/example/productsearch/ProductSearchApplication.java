package com.example.productsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages={"com.example.*"})
@EnableFeignClients
public class ProductSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductSearchApplication.class, args);
    }

}
