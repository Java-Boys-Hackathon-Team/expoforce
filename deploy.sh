#!/usr/bin/env bash

# Остановка при первой ошибке
set -e

# Вывод каждой команды перед выполнением
set -x

# Проверка наличия аргумента с названием ветки
if [ "$#" -ne 1 ]; then
  echo "Usage: $0 <branch_name>"
  exit 1
fi

# Сохраняем название ветки в переменную
BRANCH_NAME=$1

# Шаг 1: Получение последних изменений из репозитория
git fetch

# Шаг 2: Переключение на основную ветку
git checkout "$BRANCH_NAME"

# Шаг 3: Слияние последних изменений
git pull origin "$BRANCH_NAME"

# Шаг 4: Остановка всех работающих контейнеров
docker-compose down

rm -rf build
rm -rf node_modules
rm -rf frontend/generated
rm -rf src/main/bundles

# Шаг 5: Удаление всех образов из docker-compose
docker rmi -f expoforce-expoforce:latest

docker-compose rm -f
docker image prune -f --filter "label=com.docker.compose.project=expoforce"

# Шаг 6: Сборка проекта expoforce
./gradlew -Dorg.gradle.jvmargs='-Xms1g -Xmx2g' -Pvaadin.productionMode=true bootJar -x test

# Шаг 7: Запуск всех сервисов
docker-compose up -d

echo "Deployment completed successfully on branch $BRANCH_NAME"