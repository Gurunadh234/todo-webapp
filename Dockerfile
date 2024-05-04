FROM amazoncorretto
MAINTAINER gurunadhan
COPY target/*.jar app.jar
ENTRYPOINT ["java", "app.jar"]
