FROM openjdk:11
ARG JAR_FILE=artifact/*.jar
ADD ${JAR_FILE} LogarithmResolver.jar
EXPOSE 8080 8081 8082
ENTRYPOINT ["java","-javaagent:./jmx_prometheus_javaagent-0.13.0.jar=localhost:8082:config.yaml","-jar","/LogarithmResolver.jar"]