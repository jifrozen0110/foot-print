FROM eclipse-temurin:21.0.3_9-jdk

EXPOSE 8080

COPY ./build/libs/*.jar ./app.jar

ENTRYPOINT java \
-Dspring.profiles.active=${APP_PHASE} \
-jar ./app.jar
