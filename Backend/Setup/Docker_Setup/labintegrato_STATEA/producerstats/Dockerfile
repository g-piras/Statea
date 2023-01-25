FROM --platform=linux/amd64 amazoncorretto:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring && \
apk add --no-cache tzdata
USER spring:spring
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
# copy and save keystore/truststore
COPY kafka.producerstats.keystore.jks /home/spring/client-certs/kafka.producerstats.keystore.jks
COPY kafka.producerstats.truststore.jks /home/spring/client-certs/kafka.producerstats.truststore.jks
ENTRYPOINT [ "java", "-jar", "/app.jar" ]