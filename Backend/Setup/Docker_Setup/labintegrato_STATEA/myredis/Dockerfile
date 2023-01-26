FROM --platform=linux/amd64 redis:7.0.5-alpine
WORKDIR /usr/local/etc/redis
# copy redis.conf
COPY redis.conf redis.conf
# apply config
CMD redis-server /usr/local/etc/redis/redis.conf