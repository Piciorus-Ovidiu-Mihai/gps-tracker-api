####Tools needed:
* MySQL Workbench (database client)
* MySQL server (database server)
* Java JDK (>= 1.8.0, advice: for safety, please use java 1.8 or 1.10)
* Maven (>= 3.3)
* Postman REST Client

####Steps to start the application:
1) Create __gps__ schema table
From the command line:
2) __mvn clean install__
3) __mvn spring-boot:run__

From MySQL Workbench:
4) Run __add_default_roles.sql__ query using 'gps' schema.
5) Run __add_default_admin.sql__ query using'gps' schema. (for creating default admin user)

From Postman (REST Client)
6) Test existing APIs

