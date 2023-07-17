# Banking System Project

This repository contains a basic banking system project developed using Spring Boot 3.1.1, PostgreSQL, Java 17, and Jakarta for validation. The project implements the following functionalities:

## Setup

To set up and run the project locally, follow these steps:

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/andrewSky18/CRUD_Bank.git
   ```

2. Ensure that you have the following prerequisites installed:

   - Java Development Kit (JDK) 17 or higher
   - Apache Maven
   - PostgreSQL

3. Configure the PostgreSQL database:

   - Create a new database in PostgreSQL for the project.
   - Update the database connection settings in the `application.properties` file located in the `src/main/resources` directory:

     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

4. Build and run the project:

   ```shell
   cd banking-system-project
   mvn spring-boot:run
   ```

   This command will download the necessary dependencies, compile the source code, and start the Spring Boot application.

5. Access the application:

   Once the application has started successfully, you can access it by navigating to [http://localhost:8080](http://localhost:8080) in your web browser.

## Functionality

### CRUD Operations

The project provides CRUD operations for the following entities:

#### Customer

- Create a new customer record
- Retrieve customer details
- Update customer information
- Delete a customer

#### Office

- Create a new office record
- Retrieve office details
- Update office information
- Delete an office

#### Facility

- Create a new facility record
- Retrieve facility details
- Update facility information
- Delete a facility

#### Loan Product

- Create a new loan product record
- Retrieve loan product details
- Update loan product information
- Delete a loan product

#### Loan

- Create a new loan record
- Retrieve loan details
- Update loan information
- Delete a loan

### Loan Flow Cycle Management

The project aims to implement loan flow cycle management. However, this feature is currently under development. Once completed, it will provide functionality to handle the flow cycle of a loan, including stages such as loan application, approval, disbursement, repayment, and closure.

