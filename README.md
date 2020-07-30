# Babcock-Software-Engineer---test

### Install ###

1. Maven Latest Version
2. Java 11
3. MongoDB [Installation] (https://docs.mongodb.com/manual/installation/)

### Run ###

1. Run mongo - Follow [Run MongoDB Community Edition] (https://docs.mongodb.com/manual/installation/) for your system (leave on default port 27017).
2a. mvn spring-boot:run (leave on default port 8080 on localhost)
2b. or import onto IntelliJ as maven project and run main method.

### Endpoints ###

#### Get "/vehicles/hireable" ####

Gets a List of hireable vehicles in application/json response.

example:
[
    {
        "carNo": 1,
        "registrationNumber": "reggo1",
        "category": "ESTATE",
        "make": "make",
        "model": "model",
        "hired": false,
        "id": "5f21d6cc7c7da21a583f77f2"
    }
]

#### Get "/vehicle/{carNo}/date1/{date1}/date2/{date2}" ####

Get a application/text response detailing total hire rate and daily rate.

Date format for **{date1}** and **{date2}** is **"dd-MM-yyy"**, order of dates doesn't matter

**{carNo}** is from any car from **"/vehicles/hireable"** endpoint
