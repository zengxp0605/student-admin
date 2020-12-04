FROM java:8
VOLUME /tmp/tomcat
ARG JAR_FILE
ADD target/${JAR_FILE} springboot-docker.jar
ENTRYPOINT ["java","-jar","/springboot-docker.jar"]