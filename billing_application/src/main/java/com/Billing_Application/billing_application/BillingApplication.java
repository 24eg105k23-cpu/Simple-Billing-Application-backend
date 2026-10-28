package com.Billing_Application.billing_application;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingApplication.class, args);
    }

    @Bean
    CommandLineRunner loadProducts(ProductRepository repository) {
        return args -> {

            if (repository.count() == 0) {
                Product p1 = new Product();
                p1.setName("Rice");
                p1.setPrice(60);
                repository.save(p1);

                Product p2 = new Product();
                p2.setName("Sugar");
                p2.setPrice(45);
                repository.save(p2);

                Product p3 = new Product();
                p3.setName("Cooking Oil");
                p3.setPrice(150);
                repository.save(p3);

                Product p4 = new Product();
                p4.setName("Flour");
                p4.setPrice(50);
                repository.save(p4);

                Product p5 = new Product();
                p5.setName("Tea Powder");
                p5.setPrice(220);
                repository.save(p5);
            }
        };
    }
}