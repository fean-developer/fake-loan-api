#!/bin/bash

# Subir os containers
echo "Subindo os containers com Docker Compose..."
docker compose up -d

# Nome do container 
CONTAINER_NAME="mongo-loan"  # exemplo: mongo, postgres, etc.

# Tempo limite de espera (em segundos)
TIMEOUT=60
ELAPSED=0
SLEEP_INTERVAL=3

echo "Aguardando o container '$CONTAINER_NAME' iniciar..."


# Loop até o container estar "running"
while [ "$(docker inspect -f '{{.State.Running}}' "$CONTAINER_NAME" 2>/dev/null)" != "true" ]; do
  sleep $SLEEP_INTERVAL
  ELAPSED=$((ELAPSED + SLEEP_INTERVAL))
  if [ "$ELAPSED" -ge "$TIMEOUT" ]; then
    echo "Erro: o container '$CONTAINER_NAME' não iniciou em $TIMEOUT segundos."
    exit 1
  fi
done

echo "Container '$CONTAINER_NAME' está rodando. Iniciando aplicação Spring Boot..."

# Executar o Spring Boot
mvn spring-boot:run
