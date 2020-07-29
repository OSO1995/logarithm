FROM openjdk:11
ARG JAR_FILE=artifact/*.jar
ADD ${JAR_FILE} LogarithmResolver.jar
ENTRYPOINT ["java","-jar","/LogarithmResolver.jar"]