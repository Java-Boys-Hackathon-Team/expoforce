FROM eclipse-temurin:17-jdk

COPY build/libs/expoforce-0.0.1-SNAPSHOT.jar expoforce.jar

ENTRYPOINT ["java","-jar","/expoforce.jar"]