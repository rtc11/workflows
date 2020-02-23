FROM adoptopenjdk/openjdk13
COPY integration-test/target/test.jar test.jar
ENTRYPOINT ["java","-jar","test.jar"]
