# Quote Sender API

REST API для системы цитат с системой аутентификации и голосования.

## 🚀 Функциональность

### 🔐 Аутентификация
- Регистрация новых пользователей
- Вход в систему (логин)
- Выход из системы (логаут)
- Сессионная аутентификация

### 💬 Управление цитатами
- Просмотр всех цитат
- Система лайков и дизлайков
- Рейтинг цитат (топ по лайкам)
- Защита от множественного голосования

### 👥 Пользователи
- Просмотр списка пользователей
- Уникальные логины

## 📋 Требования

- Java 17+
- Maven 3.6+
- MySQL 8.0+
- Spring Boot 3.3.7

## 🛠️ Установка и запуск

### Клонирование репозитория
```bash
git clone <repository-url>
cd quotesender
```
📚 API Endpoints
Аутентификация
###Метод	Endpoint	Описание
###POST	/api/v1/quotes/registration	Регистрация пользователя
###POST	/api/v1/quotes/login	Вход в систему
###POST	/api/v1/quotes/logOut	Выход из системы
Цитаты
Метод	Endpoint	Описание
###GET	/api/v1/quotes/all	Все цитаты
###GET	/api/v1/quotes/top	Топ цитат по лайкам
###POST	/api/v1/quotes/{id}/like	Лайк цитаты
###POST	/api/v1/quotes/{id}/dislike	Дизлайк цитаты

🔐 Примеры запросов
Регистрация пользователя
http
POST /api/v1/quotes/registration
Content-Type: application/json
```bash
{
    "userLogin": "ivan",
    "userPassword": "password123"
}
```
