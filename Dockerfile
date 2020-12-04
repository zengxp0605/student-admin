FROM java:8
VOLUME /tmp/tomcat
ADD target/${JAR_FILE} springboot-docker.jar
ENTRYPOINT ["java","-jar","/springboot-docker.jar"]