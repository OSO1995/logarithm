FROM openjdk:11
ARG JAR_APP=artifact/app/*.jar
ARG JAR_JA=artifact/javaagent/jmx_prometheus_javaagent-0.13.0.jar
ARG JAR_JA_CONF=artifact/javaagent/config.yaml
ADD ${JAR_APP} LogarithmResolver.jar
ADD ${JAR_JA} jmx_prometheus_javaagent.jar
ADD ${JAR_JA_CONF} config.yaml
EXPOSE 8080 8081 8082
ENTRYPOINT ["java","-javaagent:./jmx_prometheus_javaagent.jar=8082:config.yaml","-jar","/LogarithmResolver.jar"]