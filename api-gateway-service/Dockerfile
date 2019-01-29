FROM openjdk:11
ADD ./target/api-gateway-service-0.0.1-SNAPSHOT.jar /usr/src/api-gateway-service-0.0.1-SNAPSHOT.jar
EXPOSE 8086
WORKDIR usr/src
ENTRYPOINT ["java","-jar","api-gateway-service-0.0.1-SNAPSHOT.jar"]
