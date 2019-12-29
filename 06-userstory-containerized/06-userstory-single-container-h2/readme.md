# Info

## Build & Run App Docker
`$ mvn clean install`

`$ docker run -p 8080:5000 ttt9912/06-userstory-single-container-h2:0.0.1-SNAPSHOT`

## Browser
- Docker run: port 8080
- Local run: port 5000
 
`$ curl localhost:<port>/userstories | json_pp`

```shell script
$ curl -v -X POST localhost:8080/userstories \
    -H "Content-Type:application/json" \
    -d '{"username": "paul", "description": "Learn JPA", "targetDate": "2019-12-14", "isDone": false}'
```

```shell script
$ curl -v -X PUT localhost:8080/userstories \
    -H "Content-Type:application/json" \
    -d '{"id": 10, "username": "peter", "description": "Learn AWS", "targetDate": "2019-12-14", "isDone": true}'
```

## H2 Console 
try it on deployed app

`localhost:<port>/h2-console`  

JDBC URL: `jdbc:h2:mem:testdb`


# Deploy Docker image

## Overview
- create docker image of jar
- push image to Docker Hub
- create Dockerrun.aws.json referencing the image on Docker Hub
- create EB App & Environment and just upload Dockerrun.aws.json

## Create Docker image

### Create Dockerfile
- copies the jar from /target to 'app.jar' in the container
- runs `java -jar app.jar`
- exposes port 5000 (this does not publish it to localhost)

### Spotify Dockerfile Plugin
Info: `docker-maven-plugin` is deprecated
use `dockerfile-maven-plugin`

Creates docker image based on Dockerfile

### build image
`mvn clean package`

#### local Docker repository
creates image and publishes it to the local docker
repository

```shell script
MacBook-Pro:~ ttt$ docker images
REPOSITORY                           TAG                 IMAGE ID            CREATED             SIZE
06-userstory-single-container-h2     0.0.1-SNAPSHOT      866c4168d0ba        26 seconds ago      145MB
```

#### Docker Hub repository
push image to Docker Hub

`mvn clean deploy`

##### mvn deploy
requires `distributionManagement`

Bypass: just use a local directory as pseudo mvn repository

```xml
    <distributionManagement>
        <repository>
            <id>internal.repo</id>
            <name>Internal repo</name>
            <url>file://${user.home}/dev/pseudo-mvn-repo</url>
        </repository>
    </distributionManagement>
```

### push image to Docker Hub manually
`$ docker login`  
`$ docker push 06-userstory-single-container-h2`

## Run Docker image
`$ docker run -p 06-userstory-single-container-h2:0.0.1-SNAPSHOT`

Browser: localhost:8080/userstories

## Deploy Docker Image to AWS

### create Dockerrun.aws.json file
Single Container Docker configuration  
Template: https://docs.aws.amazon.com/de_de/elasticbeanstalk/latest/dg/single-container-docker-configuration.html

- specify name of the Image to run
- Image will be pulled from Docker Hub by default

### create new Application & Environment
- Web Server Environment
- Name: 06-userstory-single-container-h2
- Platform: Docker
- Application Code: Upload Dockerrun.aws.json file

### Advantages of Docker Platform
No more Platform versions (like Java 8) have to be specified.
The container can be deployed and run anywhere.


