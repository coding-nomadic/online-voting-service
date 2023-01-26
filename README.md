## Online-Voting-System

Pre-requisites are - Java and Maven (for build) and Node JS should be installed in the machine. 

For SpringBoot application. Run the application with command -

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

For Angular Application. Goto the folder where package.json is presend and run this command
```
npm install -g @angular/cli
```
In the same folder structure, run the command to install all npm packages -
```
npm install
```
In the same folder, run the command to start the application - 
```
ng serve
```
Now, access the angular UI from this URL -http://localhost:4200.
