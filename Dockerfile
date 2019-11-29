#FROM tomcat:jdk13-openjdk-oracle

FROM tomcat:8.5-alpine

ADD target/edith-1.0.war /usr/local/tomcat/webapps/edith.war

EXPOSE 8080
EXPOSE 6379
CMD ["catalina.sh", "run"]