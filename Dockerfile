FROM openjdk:21-jdk-slim
COPY ./target/inditex-prices-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=local"]