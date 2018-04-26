FROM maven:3.5-jdk-8-alpine

RUN ls -l

WORKDIR /code

ADD . /code/


CMD ["java", "-jar", "target/InciDashboard_i1a-0.0.1-SNAPSHOT.jar", "--spring.data.mongodb.host=mongo_data", "--spring.kafka.bootstrap-servers=kafka:9092"]
