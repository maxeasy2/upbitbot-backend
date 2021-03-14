FROM azul/zulu-openjdk-alpine:11
MAINTAINER maxeasy2@naver.com

RUN mkdir -p /webapp
RUN chmod 777 /webapp
RUN apk add --no-cache bash
RUN apk add curl
RUN apk add vim
RUN apk add busybox-extras

COPY "target/upbitbot-backend-0.0.1.jar" "/webapp/upbitbot-backend.jar"
COPY "startup.sh" "/webapp/startup.sh"

ENTRYPOINT [ "/bin/bash", "/webapp/startup.sh" ]