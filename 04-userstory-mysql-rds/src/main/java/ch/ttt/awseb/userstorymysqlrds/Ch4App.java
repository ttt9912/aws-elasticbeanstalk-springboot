package ch.ttt.awseb.userstorymysqlrds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * ---------------------------------------------
 * Local Mysql & PhpMyAdmin Docker
 * ---------------------------------------------
 * $ docker-compose up
 *
 * ---------------------------------------------
 * PhpMyAdmin Local
 * ---------------------------------------------
 * localhost:8183
 * (login does not work...)
 *
 * ---------------------------------------------
 * Mysql CLI local
 * ---------------------------------------------
 * $ docker exec -it mysql_local mysql -u root -p
 * password   : root
 *
 * $ create database userstory;
 * $ use userstory;
 * $ create table hibernate_sequence (next_val bigint) engine=InnoDB;
 * $ insert into hibernate_sequence values ( 1 );
 * $ create table userstory (id integer not null, description varchar(255), is_done boolean not null, target_date datetime(6), username varchar(255), primary key (id)) engine=InnoDB;
 *
 * ---------------------------------------------
 * Browser
 * ---------------------------------------------
 * - localhost:5000/userstories
 *
 * $ curl -X POST -d '{"username": "paul", "description": "Learn JPA", "targetDate": "2019-12-14", "isDone": false}' -H "Content-Type:application/json" localhost:5000/userstories
 * $ curl -X PUT -d '{"id": 10, "username": "peter", "description": "Learn AWS", "targetDate": "2019-12-14", "isDone": true}' -H "Content-Type:application/json" localhost:5000/userstories
 *
 */
@SpringBootApplication
public class Ch4App {

    public static void main(final String[] args) {
        SpringApplication.run(Ch4App.class, args);
    }
}