FROM openjdk:11
ARG JAR_APP=artifact/app/*.jar
ARG JAR_JA=artifact/javaagent/*.jar
ADD ${JAR_APP} LogarithmResolver.jar
ADD ${JAR_JA} jmx_prometheus_javaagent.jar
EXPOSE 8080 8081 8082
ENTRYPOINT ["java","-javaagent:./jmx_prometheus_javaagent.jar=localhost:8082:config.yaml","-jar","/LogarithmResolver.jar"]