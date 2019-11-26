#FROM tomcat:jdk13-openjdk-oracle

#FROM tomcat:8.5-alpine

FROM tomcat:jdk8-adoptopenjdk-openj9

#ADD target/retwisj-0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

ADD target/retwisj-0.0.1-SNAPSHOT.war $CATALINA_HOME/webapps/retwis.war

EXPOSE 8080
#EXPOSE 6379
CMD ["catalina.sh", "run"]