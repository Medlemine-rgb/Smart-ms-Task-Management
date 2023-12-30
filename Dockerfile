FROM openjdk:21-ea-9-jdk-slim
EXPOSE 8081
WORKDIR C:/Users/Mahvoudha/Desktop/Formation-smart/TaskManagement-0.0.1-SNAPSHOT.jar
ADD target/TaskManagement-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","TaskManagement-0.0.1-SNAPSHOT.jar"]