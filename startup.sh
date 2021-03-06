#!/bin/bash

java -jar ${HEAP_XMS:-"-Xms256m"} ${HEAP_XMX:-"-Xmx256m"} \
    -XX:+HeapDumpOnOutOfMemoryError \
    -XX:HeapDumpPath=/webapp/logs \
    -Dfile.encoding=UTF-8 \
	  -Dlogdir=/webapp/logs \
	  -Dspring.profiles.active=${PROFILE:-prod} \
	  -Dinterfaces.notification.telegram.bottokenkey=${TELEGRAM.BOTTOKEN_KEY} \
	  -Dinterfaces.notification.telegram.bottokenvalue=${TELEGRAM.BOTTOKEN_VALUE} \
	  -Dinterfaces.notification.telegram.chatid==${TELEGRAM.CHAT_ID} \
    -Dspring.datasource.hikari.username=${DATABASE_USERNAME} \
    -Dspring.datasource.hikari.password=${DATABASE_PASSWORD} \
    -Ddatabase.host=${DATABASE_HOST} \
	/webapp/upbitbot-backend.jar