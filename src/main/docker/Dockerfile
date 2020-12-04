FROM java:8
VOLUME /tmp/tomcat
ADD student-admin-1.3-SNAPSHOT.jar springboot-docker.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-docker.jar"]