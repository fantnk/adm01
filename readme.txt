Настроить соединение с БД в resources/db/mysql.properties. БД при каждом деплое инициализируется, наполняется тестовыми данными из скрипта src/main/resources/db/populateDB.sql.
Выполнить mvn clean package.
Выполнить деплой файла target/adm01.war на сервер Tomcat.
Открыть в  браузере http://server:port/adm01

Протестировано на MySQL 5.7.12, Tomcat 8.0.33.