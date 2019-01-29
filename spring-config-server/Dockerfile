FROM openjdk:11
ADD ./target/spring-config-server-0.0.1-SNAPSHOT.jar /usr/src/spring-config-server-0.0.1-SNAPSHOT.jar
EXPOSE 8082
WORKDIR usr/src
ENTRYPOINT ["java","-jar","spring-config-server-0.0.1-SNAPSHOT.jar"]
