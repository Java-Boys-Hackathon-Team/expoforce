# ЭКСПОХАК Hackaton 2024

### Создание системы управления клиентскими базами среди компаний-партнеров Экспобанка

### Внимание!


**Система уже развернута в интернете и вы можете с ней ознакомиться без локальной установки**

- Испытать в браузере: [https://expo-force.ru/login](https://expo-force.ru/login)
- Для получения доступа обратитесь к разработчикам!

### Команда разработки:
- Рустам Курамшин - @KuramshinRustam
- Александр Янчий - @AlexYanchiy
- Рустам Зулкарниев - @WerderR
- Владислав Калинин - @First_Kalinin
- Рустам Гулямов - @gulyamovrustam
- Роман Горбатенко - @Elanlum

### Запуск проекта

- Клонируйте репозиторий с GitHub

- Скачайте и установите JDK 17 для своей ОС на сайте Eclipse [по этой ссылке](https://adoptium.net/temurin/releases/)

- Выполните команду сборки:

```shell
# linux or mac os
./gradlew -Pvaadin.productionMode=true bootJar

# windows 
gradlew.bat -Pvaadin.productionMode=true bootJar
```

- Установите Docker Desktop с [официального сайта](https://www.docker.com/products/docker-desktop/)

- Запустите все контейнеры docker-compose следующей командой:
```shell
docker-compose up -d
```

- Чтобы войти в систему "ExpoForce" перейдите по ссылке [http://localhost:8080](http://localhost:8080). Логин: "admin", пароль: "admin".