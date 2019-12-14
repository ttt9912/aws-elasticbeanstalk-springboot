package ch.ttt.awseb.userstoryh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * ---------------------------------------------
 * Browser
 * ---------------------------------------------
 * - localhost:5000/userstories
 *
 * POST localhost:5000/userstories
 * {"username": "paul", "description": "Learn JPA", "targetDate": "2019-12-14", "done": false}
 *
 * PUT localhost:5000/userstories
 * {"id": 10001, "username": "thomas", "description": "Learn JPA", "targetDate": "2019-12-14", "done": false}
 *
 * ---------------------------------------------
 * H2 Console (try it on deployed app)
 * ---------------------------------------------
 * localhost:5000/h2-console
 *
 * - JDBC URL   : jdbc:h2:mem:testdb
 */
@SpringBootApplication
public class RestfulWebServicesApplication {

    public static void main(final String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }
}
