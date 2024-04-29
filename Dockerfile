FROM httpd
MAINTAINER gurunadhan
COPY target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
