FROM openjdk:17
LABEL maintainer="com.csi"
ADD target/dockercore-0.0.1-SNAPSHOT.jar dockercore.jar
ENTRYPOINT ["java", "-jar", "dockercore.jar"]