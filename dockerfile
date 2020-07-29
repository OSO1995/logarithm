FROM openjdk:11
ARG JAR_FILE=artifact/*.jar
ADD ${JAR_FILE} LogarithmResolver.jar
EXPOSE 8080 8081
ENTRYPOINT ["java","-jar","/LogarithmResolver.jar"]