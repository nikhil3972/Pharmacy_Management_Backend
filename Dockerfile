FROM openjdk:17
ADD target/manager-0.0.1-SNAPSHOT.jar springboot-backend-docker.jar
ENTRYPOINT [ "java","-jar","springboot-backend-docker.jar" ]