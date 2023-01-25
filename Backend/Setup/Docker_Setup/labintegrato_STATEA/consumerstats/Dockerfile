FROM --platform=linux/amd64 amazoncorretto:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring && \
apk add --no-cache tzdata
USER spring:spring
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
# copy and save keystore/truststore
COPY kafka.consumerstats.keystore.jks /home/spring/client-certs/kafka.consumerstats.keystore.jks
COPY kafka.consumerstats.truststore.jks /home/spring/client-certs/kafka.consumerstats.truststore.jks
ENTRYPOINT [ "java", "-jar", "/app.jar" ]