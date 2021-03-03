# Java Spring Data MongoDB

__[Spring Data for MongoDB](https://spring.io/projects/spring-data-mongodb)__ is under the umbrella project of Spring Data which aims to provide a familiar and consistent Spring-based programming model for new datastores while retaining store-specific features and capabilities.

In this repository, we will be using __MongoRepository__ in persisting our model. In addition, we will be learning how to implement a sequential, auto-generated ID for MongoDB in Spring Boot. We cannot use __@GeneratedValue__ annotation in our models/entities when using MongoDB in Spring Boot as it is not available. Hence, we need a way to produce the same effect when using JPA with a relational database.

The approach I did is to create a collection (see [DatabaseSequence](https://github.com/junbetterway/spring-data-mongodb-basic/blob/main/src/main/java/com/junbetterway/springmongo/entity/DatabaseSequence.java)) that will store the generated sequence for other collections. During the creation of a new record, we will use it to fetch the current value then increment to support sequential IDs (e.g., Integer, Long) - see [SequenceGeneratorService](https://github.com/junbetterway/spring-data-mongodb-basic/blob/main/src/main/java/com/junbetterway/springmongo/service/SequenceGeneratorService.java)

## Run the needed dependencies: MongoDB and (optional) Mongo Express using Docker

*__Note:__ We will be using __[Mongo Express](https://hub.docker.com/_/mongo-express)__ which is a web-based MongoDB admin interface, written with Node.js and express for better testing and checking of data.*

1. Make sure to install **[Docker](https://docs.docker.com/get-docker/)** on your machine
2. Go to the root directory of the project where __docker-compose.yml__ is located.
3. Run the docker compose by

```
docker-compose up
```

*__Note:__ Make sure no errors are present on the logs such as connection refused etc. Now go to your browser and access __http://localhost:8081/__ for the Mongo Express. The user credentials are listed in the __docker-compose.yml__ - see values for __ME_CONFIG_BASICAUTH_USERNAME__ and __ME_CONFIG_BASICAUTH_PASSWORD__.*

## Run the Spring Boot Application Using Spring Tool Suite (STS)
1. Download STS version 3.4.* (or better) from the [Spring website](https://spring.io/tools). STS is a free Eclipse bundle with many features useful for Spring developers.
2. Right-click on the project or the main application class then select "Run As" > "Spring Boot App"

## Powered By
Contact me at [junbetterway](mailto:jkpminon12@yahoo.com)

Happy coding!!!
