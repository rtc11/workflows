FROM adoptopenjdk/openjdk13
COPY api/target/api.jar api.jar
ENTRYPOINT ["java","-jar","api.jar"]