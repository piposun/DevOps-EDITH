#FROM tomcat:jdk13-openjdk-oracle

FROM tomcat:8.5-alpine

ADD target/retwisj-0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080
EXPOSE 6379
CMD ["catalina.sh", "run"]