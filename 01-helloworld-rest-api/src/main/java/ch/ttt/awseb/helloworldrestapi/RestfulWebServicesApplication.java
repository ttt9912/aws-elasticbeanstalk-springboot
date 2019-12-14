package ch.ttt.awseb.helloworldrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * ---------------------------------------------
 * Browser
 * ---------------------------------------------
 * - localhost:5000/hello-world-bean
 * - localhost:5000/hello-world/path-variable/thomas
 */
@SpringBootApplication
public class RestfulWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }
}
