FROM openjdk:11
MAINTAINER DarinaZaviazun

RUN mkdir -p /app

COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

WORKDIR /app
