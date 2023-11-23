## Basketball App

# Introduction
This project aims to create a simple Basketball Application using microservices. There is a single config server holding all the property files for the 
microserviecs. There are four microservices in total:
    1. PersonService - Holds general info for each user of the application.
    2. PlayerMetricService - Tracks basketball statistics for each basketball player.
    3. TeamService - Keeps track of the team statistics.
    4. PracticeService - Used to create practice plans and store information about past practices.

## Initial Configuration
1.	Apache Maven (http://maven.apache.org)  All of the code examples in this book have been compiled with Java version 21.
2.	Git Client (http://git-scm.com)
3.  Docker(https://www.docker.com/products/docker-desktop)

## How To Use

To clone and run this application, you'll need [Git], [Maven], [Java 21]. From your command line:

```bash
# Clone this repository
$ git clone https://github.com/johnsonwyo/BasketballApp.git

# If not already there, go into the repository, by changing to the directory where you have downloaded the 
# Services source code
$ cd Services

# To build the services code for Services as a docker image, open a command-line 
# window and execute the following command:
$ mvn clean package dockerfile:build

# Now we are going to use docker-compose to start the actual image.  To start the docker image, stay in the directory containing your Services source code and Run the following command: 
$ docker-compose -f docker/docker-compose.yml up
```

# The build command

Will execute the [Spotify dockerfile plugin](https://github.com/spotify/dockerfile-maven) defined in the pom.xml file.  

Running the above command at the root of the project directory will build all of the projects.  If everything builds successfully you should see a message indicating that the build was successful.

# The Run command

This command will run our services using the docker-compose.yml file located in the /docker directory. 

If everything starts correctly you should see a bunch of Spring Boot information fly by on standard out.  At this point all of the services needed for the Services code will be running.

# Database
You can find the database scripts as well in the docker directory.