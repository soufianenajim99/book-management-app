FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM tomcat:10.1-jdk17

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=builder /app/target/booksdemo-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]