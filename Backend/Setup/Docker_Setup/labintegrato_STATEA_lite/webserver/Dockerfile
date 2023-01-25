FROM --platform=linux/amd64 amazoncorretto:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring && \
apk add --no-cache tzdata
USER spring:spring
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]