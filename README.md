# GIF RECEIVER
## Техническое задание
Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:       
если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную [отсюда](https://giphy.com/search/rich)   
если ниже - [отсюда](https://giphy.com/search/broke)   
**Ссылки**  
[REST API курсов валют](https://docs.openexchangerates.org/)   
[REST API гифок](https://developers.giphy.com/docs/api#quick-start-guide)   
**Must Have**   
Сервис на Spring Boot 2 + Java / Kotlin   
Запросы приходят на HTTP endpoint, туда передается код валюты   
Для взаимодействия с внешними сервисами используется Feign   
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки   
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)   
Для сборки должен использоваться Gradle   
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску   
**Nice to Have**   
Сборка и запуск Docker контейнера с этим сервисом»   
***
## Stack
- Open JDK 8    
- Spring Boot
- Spring Cloud(OpenFeign)  
- Lombok
- Mockito
- JUnit 5
***
## Запуск
- Склонировать репозиторий, выполнив команду:   
`git clone https://github.com/Fr0z3Nn/alfa-bank.git`   
- Перейдя в корневую папку проекта собрать проект:    
`gradlew build`   
- Собрать докер-образ с произвольным именем, в нашем случае alfa:    
`docker image build -t alfa .`   
- Запустить контейнер с нашим образом:   
`docker run -p 9090:9090 docker.io/library/alfa`   
***
## Endpoints
- `/api/gif`  
Возвращает гифку в зависимости от курса валют   
**Parameters**   
base: string (AED)   
**_Пример_**   
`http://localhost:9090/api/gif?base=AED`
------
- `/api/*`  
Возвращает гифку в зависимости от курса валюты (USD)    
**_Пример_**   
`http://localhost:9090/api/something`
***
 ## Примечание
 - API, представляющее гифки бесплатно только для базовой валюты USD, в случае передачи другой будет выброщен соответствующий ответ от сервера.
 - Список доступных валют можно посмотреть [здесь](https://openexchangerates.org/api/currencies.json)
  