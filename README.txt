1. скачать проект
2. создать базу Mysql локально
    url: jdbc:mysql://host.docker.internal:3306/test_app
    username: admin
    password: password
3. выполнить скрипты заполнения из каталога /dbmig
4. Для создания и запуска Docker-контейнера выполнить  maven.sh, docker_build.sh
5. запуск приложения: localhost:8080/companies

