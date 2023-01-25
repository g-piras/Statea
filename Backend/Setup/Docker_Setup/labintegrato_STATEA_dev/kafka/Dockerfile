FROM --platform=linux/amd64 bitnami/kafka:3.1.2
WORKDIR /bitnami/kafka/config/certs
# copy and save keystore/truststore
COPY kafka.server.keystore.jks kafka.keystore.jks
COPY kafka.server.truststore.jks kafka.truststore.jks