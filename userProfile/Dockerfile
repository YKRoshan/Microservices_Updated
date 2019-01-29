FROM openjdk:11
ADD ./target/userProfile-0.0.1-SNAPSHOT.jar /usr/src/userProfile-0.0.1-SNAPSHOT.jar
EXPOSE 8084
WORKDIR usr/src
ENTRYPOINT ["java","-jar","userProfile-0.0.1-SNAPSHOT.jar"]
