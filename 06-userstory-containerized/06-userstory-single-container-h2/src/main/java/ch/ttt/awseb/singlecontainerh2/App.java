package ch.ttt.awseb.singlecontainerh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *
 * ---------------------------------------------
 * Build & Run Docker
 * ---------------------------------------------
 * $ mvn clean install
 *
 * $ docker run -p 8080:5000 ttt9912/06-userstory-single-container-h2:0.0.1-SNAPSHOT
 *
 * ---------------------------------------------
 * Browser
 * ---------------------------------------------
 * Docker run   : port 8080
 * Local run    : port 5000
 *
 * localhost:8080/userstories
 *
 * $ curl localhost:8080/userstories | json_pp
 *
 $ curl -v -X POST localhost:8080/userstories \
    -H "Content-Type:application/json" \
    -d '{"username": "paul", "description": "Learn JPA", "targetDate": "2019-12-14", "isDone": false}'

 $ curl -v -X PUT localhost:8080/userstories \
    -H "Content-Type:application/json" \
    -d '{"id": 10, "username": "peter", "description": "Learn AWS", "targetDate": "2019-12-14", "isDone": true}'
 *
 * ---------------------------------------------
 * H2 Console (try it on deployed app)
 * ---------------------------------------------
 * localhost:5000/h2-console
 * - JDBC URL   : jdbc:h2:mem:testdb
 */
@SpringBootApplication
public class App {
    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}
