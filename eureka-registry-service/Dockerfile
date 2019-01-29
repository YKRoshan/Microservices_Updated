FROM openjdk:11
ADD ./target/eureka-registry-service-0.0.1-SNAPSHOT.jar /usr/src/eureka-registry-service-0.0.1-SNAPSHOT.jar
EXPOSE 8085
WORKDIR usr/src
ENTRYPOINT ["java","-jar","eureka-registry-service-0.0.1-SNAPSHOT.jar"]
