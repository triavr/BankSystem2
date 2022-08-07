# Банковское приложение, использующее Java11, Spring Boot, Spring Security и PostgreSQL

RESTful API для имитации простых банковских операций. 

## Основные операции в системе:

*	Операции CRUD для клиентов и учетных записей
*	Обслуживание счетов клиентов 
*	Поддержка внутренних переводов (Клиент может переводить средства с одного счета на другой)


## Необходимо: 

1. Склонируйте проект с GitHub

```
git clone https:

```
2. Включите поддержку Lombok в вашей IDE



```
3. Откройте IDE и импортируйте как существующий проект maven 

```
-

```
4. Порт по умолчанию для API - 8080


### Основные требования

* Java 11
* Maven

### Maven зависимости

```
spring-boot-starter-data-jpa
spring-boot-starter-security
spring-boot-starter-web
spring-boot-devtools
org.postgresql
lombok 
spring-boot-starter-test
spring-security-test

```


## Установите Postgresql
```
   Создайте базу данных и определите ее в файле application.properties


