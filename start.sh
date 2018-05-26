#!/bin/bash
echo "======================================================="
echo "inicia instalacion contenedor!"
echo "======================================================="
echo "compila aplicacion"
mvn clean package -Dmaven.test.skip=true
echo "======================================================="
echo "======================================================="
echo "compila imagen docker - integration_queue"
docker build -t integration_queue .
echo "======================================================="
echo "======================================================="
echo "corre imagen del contenedor"
docker run \
 --name integration_queue \
 -p 9099:9099 \
 -d -it integration_queue
echo "======================================================="
echo "======================================================="
echo "fin"
exit
