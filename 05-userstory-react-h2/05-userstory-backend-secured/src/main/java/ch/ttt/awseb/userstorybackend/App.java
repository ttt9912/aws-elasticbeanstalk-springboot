package ch.ttt.awseb.userstorybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Backend & Frontend are deployed separately
 * - Backend    ->  Elastic Beanstalk
 * - Frontend   ->  S3
 *
 * ---------------------------------------------
 * Browser
 * ---------------------------------------------
 * localhost:5000/userstories
 *
 * $ curl -v -X POST -d '{"username": "paul", "description": "Learn JPA", "targetDate": "2019-12-14", "isDone": false}' -H "Content-Type:application/json" localhost:5000/userstories
 * $ curl -v -X PUT -d '{"id": 10, "username": "peter", "description": "Learn AWS", "targetDate": "2019-12-14", "isDone": true}' -H "Content-Type:application/json" localhost:5000/userstories
 */
@SpringBootApplication
public class App {

    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}
