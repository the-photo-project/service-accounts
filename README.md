# service-accounts

The accounts micro service, that allows users to register, login, change password, reset password, etc.

## Run

Run the application with
```./mvnw spring-boot:run```

The application will listen on port 8081 and a first hello controller was added which you can test here: http://localhost:8081

## Docker Build

To build the docker image for the micro service, first ensure that you have Docker installed, then run this command

```
docker build --tag service-accounts .
```

After building the image, you can verify that it has been created using this command:

```
docker images
```

You should see this output showing the image with tag "latest":

```
REPOSITORY                   TAG              IMAGE ID       CREATED              SIZE
service-accounts             latest           21e550f4103a   47 seconds ago       288MB
```

To run the built image in a container, you can do this:

```
docker run --rm --detach --publish 8081:8081 --name srvacts-server service-accounts
```

After waiting a bit of time for the container to start, you can point your browser at http://localhost:8081 as above, to verify that the container is running and port 8081 has been forwarded through to the container.

You can verify the container is running using:

```
docker ps
```

Then shut down the container using:

```
docker stop srvacts-server
```

Docker can be installed from here: https://docs.docker.com/get-docker/

## Docker Compose Run

To build all of the project containers and start them, use this command:

```
docker-compose up -d
```

To shut them down, use this:

```
docker-compose down
```

There is one known bug: On the first run of docker-compose, it incorrectly runs a container with the wrong image (the build image, not the prod image).  The work-around is to make sure that the JAR file is in the same place in both images.  Hopefully the folks at docker-compose will fix this soon.  Eventually I guess we will move off docker-compose and do deploys via CI/CD.

See [Project Help](HELP.md) for further guides.
