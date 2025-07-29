# Docker file for the Read Service
#
# Version 0.0.1

#jdk image
FROM eclipse-temurin:17

# install
# label for the image
LABEL Description="mock-service" Version="0.0.1"

# the version of the archive
ARG VERSION=0.0.1

# mount the temp volume

VOLUME /tmp

# Add the service as app.jar
ADD target/mock-service-${VERSION}-SNAPSHOT.jar app.jar

# touch the archive for timestamp
RUN sh -c 'touch /app.jar'

# entrypoint to the image on run
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 9190


