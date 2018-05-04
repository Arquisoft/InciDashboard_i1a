FROM maven:3.5-jdk-8-alpine
RUN ls -l
WORKDIR /code
ADD . /code/
RUN mvn package -Dmaven.test.skip=true
EXPOSE 8082
CMD ["java", "-jar", "target/InciDashboard_i1a-0.0.1-SNAPSHOT.jar", "--spring.kafka.bootstrap-servers=kafka:9092"]
