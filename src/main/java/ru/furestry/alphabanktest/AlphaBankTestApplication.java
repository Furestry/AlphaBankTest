package ru.furestry.alphabanktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main class
 *
 * @author Sevler
 */
@SpringBootApplication
@EnableFeignClients
public class AlphaBankTestApplication {

    /**
     * Start method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AlphaBankTestApplication.class, args);
    }

}
