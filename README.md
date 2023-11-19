# CharFrequency API

Данный REST API вычисляет частоту встречи символов в заданной строке и возвращает результат в формате JSON, отсортированный в порядке убывания частоты.

## Запуск приложения

1. Убедитесь, что у вас установлен Java 8+.
2. Клонируйте репозиторий:

   ```bash
   https://github.com/SpiderChung/impulse.git
   
3. Перейдите в папку с проектом

    ```bash
   cd impulse

4. Запустить тесты

   ```bash
   ./mvnw

4. Запустите приложение

   ```bash
   ./mvnw spring-boot:run

## Документация по API

Расчет частоты повторения символов

Эндпоинт: localhost:8080/charFrequency

Метод: POST

Тело запроса:

   ```json
   {
      "input": "ваша-строка"
   }
  ```

## Пример

   ```json
      {
         "input": "aaaaabcccc"
      }
```
## Ответ:

   ```json
   {
      "frequencies": [
         {"character": "a", "quantity": 5},
         {"character": "c", "quantity": 4},
         {"character": "b", "quantity": 1}
      ]
   }