# Car Server Spring Boot

Это серверное приложение для управления информацией о автомобилях, разработанное с использованием Spring Boot.

## Функциональность
- **SpringSecurity**
- **Добавление автомобилей**: возможность добавлять новые автомобили в систему.
- **Просмотр списка автомобилей**: получение списка всех зарегистрированных автомобилей.
- **Обновление информации об автомобиле**: редактирование данных существующего автомобиля.
- **Удаление автомобиля**: удаление информации об автомобиле из системы.

## Требования

- **Java 17**: убедитесь, что у вас установлена версия Java 17 или выше.
- **Maven**: для управления зависимостями и сборки проекта.

## Установка и запуск

1. **Клонирование репозитория**:
   ```bash
   git clone https://github.com/dramazzan/car-server-springboot.git
   ```
2. **Переход в директорию проекта**:
   ```bash
   cd car-server-springboot
   ```
3. **Сборка проекта с помощью Maven**:
   ```bash
   ./mvnw clean install
   ```
4. **Запуск приложения**:
   ```bash
   java -jar target/car-server-springboot-0.0.1-SNAPSHOT.jar
   ```

## Использование

После запуска приложение будет доступно по адресу `http://localhost:8080`. Вы можете использовать инструменты, такие как Postman или cURL, для взаимодействия с API.

## Документация API

- **GET /cars**: получить список всех автомобилей.
- **POST /cars**: добавить новый автомобиль.
- **GET /cars/{id}**: получить информацию о конкретном автомобиле по его ID.
- **PUT /cars/{id}**: обновить информацию о конкретном автомобиле.
- **DELETE /cars/{id}**: удалить автомобиль из системы.


---


