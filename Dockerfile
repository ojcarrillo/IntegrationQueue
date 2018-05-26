FROM openjdk:8-jdk-alpine
VOLUME ["/tmp","/var/netgloo_blog/logs/application.log"]
ADD target/IntegrationQueue.jar app.jar
CMD java -jar app.jar
EXPOSE 9099
