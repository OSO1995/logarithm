FROM openjdk:11
ARG JAR_APP=artifact/app/*.jar
ARG JAR_JA=artifact/javaagent/jmx_prometheus_javaagent-0.13.0.jar
ARG JAR_JA_CONF=artifact/javaagent/config.yaml
ARG FLUENTD_CONF=artifact/fluentd/flu.conf
ADD ${JAR_APP} LogarithmResolver.jar
ADD ${JAR_JA} jmx_prometheus_javaagent.jar
ADD ${JAR_JA_CONF} config.yaml
ADD ${FLUENTD_CONF} flu.conf
EXPOSE 8080 8081 8082
ENTRYPOINT ["java","-Djava.rmi.server.hostname=127.0.0.1","-Dcom.sun.management.jmxremote.port=1099","-Dcom.sun.management.jmxremote.rmi.port=1099","-Dcom.sun.management.jmxremote.authenticate=false","-Dcom.sun.management.jmxremote.ssl=false","-javaagent:./jmx_prometheus_javaagent.jar=8082:config.yaml","-jar","/LogarithmResolver.jar"]