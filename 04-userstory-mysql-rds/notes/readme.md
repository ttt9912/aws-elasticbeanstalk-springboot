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