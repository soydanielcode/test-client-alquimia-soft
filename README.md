# Test-client-alquimia-soft
Aplication Test for Billing of the Customer management module.
## Configuration
### **Name DATABASE:** alquimiatest
### Java 17
## **!Important**
### Execute the init_databse.sql file that is inside the database folder.
####  The server port is 999, you can change in application.properties
```
server.port=999
```

### I recommend using the following link to test the services instead of postman.
http://localhost:999/doc/swagger-ui/index.html#/

## !Important
### The different validations of Id null or repeated ID and others are controlled with messages in the console and send a status error 500 in the "Response Body", they are controlled error messages.
```agsl
{
  "timestamp": "2023-07-28T00:54:33.767+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/api/branch_address/23"
}
```

 