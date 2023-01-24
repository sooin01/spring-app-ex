FROM openjdk:8-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Xms1g -Xmx1g", "-jar", "/app.jar"]
