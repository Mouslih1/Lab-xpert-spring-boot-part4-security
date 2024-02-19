FROM openjdk:8-jdk

WORKDIR /app

COPY target/labxpert-0.0.1-SNAPSHOT.jar /app/labxpert.jar

EXPOSE 8081

CMD ["java", "-jar" ,"labxpert.jar"]