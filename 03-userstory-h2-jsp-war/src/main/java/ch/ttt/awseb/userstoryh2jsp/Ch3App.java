package ch.ttt.awseb.userstoryh2jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
 * - SpringBootServletInitializer - for running the app as .war
 *
 * - port 8080, because it is .war and will be deployed to Tomcat
 *   on Elastic Beanstalk
 *
 * ---------------------------------------------
 * Browser
 * ---------------------------------------------
 * - localhost:8080
 * - login: thomas/pass1
 *
 */
@SpringBootApplication
public class Ch3App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Ch3App.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(Ch3App.class, args);
    }
}
