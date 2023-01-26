## Online-Voting-System

Pre-requisites are - Java and maven (for build) and Node js should be installed in the machine. 

For SpringBoot application. Run the application.

```
mvn spring-boot:run
```
Access the browser and navigate below URL and provide the JDBC URL as mentioned below - 
```
http://localhost:8080/h2-console
```
```
jdbc:h2:mem:testdb
```

Access - http://localhost:8080/api to make sure APIs are up and running.


For Angular Application - 
1. Goto the folder where package.json is there and run this -npm install -g @angular/cli
2. In the same folder structure, run the command -npm install.
3. In the same folder, run the command -ng serve.
4. Access the url -http://localhost:4200.
