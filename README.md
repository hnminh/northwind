# Northwind Project

This is a project using RESTful to manage the Microsoft's well known Northwind database. This project use VAMK's MySQL as the database's server, and Spring Boot to create the REST server. It also uses Swagger for user interface.

## Features

* GET, POST, PUT, DELETE database
* Auto generates entities
* Auto generates repositories & controllers

## Usage

Since the project uses Maven and Lombok-wired JPA, we can easilly generate entities by running command

```bash
mvn jpa-entity-generator:generateAll
```

I also created a file names ```CreateRepositoryAndController.java```, which can auto-create all the Repository and Controller files for each entity. Just run it after getting all the entity files.

We can easily send requests to the server by any REST client, or by accessing to the page
```https
https://localhost:8443/swagger-ui.html#/
```
This page use the Swagger UI, and through this we can easily CRUD the database.

Since this is a school project, I need to use my VAMK's account to login for LDAP authentication if required.