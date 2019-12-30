# Info

## Browser
 
`$ curl localhost:5000/userstories | json_pp`

```shell script
$ curl -v -X POST localhost:5000/userstories \
    -H "Content-Type:application/json" \
    -d '{"username": "paul", "description": "Learn JPA", "targetDate": "2019-12-14", "isDone": false}'
```

```shell script
$ curl -v -X PUT localhost:5000/userstories \
    -H "Content-Type:application/json" \
    -d '{"id": 10, "username": "peter", "description": "Learn AWS", "targetDate": "2019-12-14", "isDone": true}'
```

## H2 Console 
try it on deployed app

`localhost:5000/h2-console`  

JDBC URL: `jdbc:h2:mem:testdb`


# EB CLI

### Install 
https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/eb-cli3-install-osx.html

`$ brew update`

`$ brew install awsebcli`

`$ eb --version`
