FROM openjdk:20

WORKDIR /app
COPY target/emp-manager-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "emp-manager-0.0.1-SNAPSHOT.jar"]