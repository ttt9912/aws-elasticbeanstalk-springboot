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
 * $ curl localhost:5000/userstories | json_pp
 *
 $ curl -v -X POST localhost:5000/userstories \
    -H "Content-Type:application/json" \
    -d '{"username": "paul", "description": "Learn JPA", "targetDate": "2019-12-14", "isDone": false}'

 $ curl -v -X PUT localhost:5000/userstories \
    -H "Content-Type:application/json" \
    -d '{"id": 10, "username": "peter", "description": "Learn AWS", "targetDate": "2019-12-14", "isDone": true}'
 *
 */
@SpringBootApplication
public class App {

    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}
