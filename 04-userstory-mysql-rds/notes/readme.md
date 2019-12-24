# Persistence - Amazon RDS (Relational Database Service)

### Create app with MySQL
- Local Connection: mysql docker  

### Create New Application
- Name: 04-userstory-mysql-rds

### Create Environment
- Name: 04-UserstoryMysqlRds-dev  
- Upload Jar  

### Configure more options
- Database
- Username	: devUser
- Password	: pass1234
- Retention	: Delete (DB is deleted when Environment is destroyed)
- Availability	: low  
- -> Save  
- -> Create Environment

## RDS Environment Variables
`RDS_HOSTNAME`
`RDS_PORT`
`RDS_DB_NAME`
`RDS_USERNAME`
`RDS_PASSWORD`  
are automatically set by Elastic Beanstalk, no manual Environment configuration necessary