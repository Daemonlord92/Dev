FROM openjdk:17-ea-18-jdk-buster
RUN apt-get update && apt-get upgrade -y

LABEL authors="matthewjeshuamartin"

WORKDIR /monster-trainer

ENV JAVA_HOME=/usr/local/openjdk-17

ENV PATH="${JAVA_HOME}/bin:${PATH}"

COPY mvnw mvnw.cmd ./
COPY .mvn/ .mvn/
COPY pom.xml ./

RUN chmod +x ./mvnw

RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

EXPOSE 8080