FROM eclipse-temurin
MAINTAINER gurunadhan
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
