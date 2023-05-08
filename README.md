# ОФОРМЛЕНИЕ КРЕДИТА 💸

Выпускной проект для Финтех Академии МТС.

## Бизнес требования

- [x] Клиент должен иметь возможность получить тарифы и условия кредита
- [x] Клиент должен иметь возможность подать заявку на кредит
- [x] Клиент должен иметь возможность получить статус заявки на кредит
- [x] Клиент должен иметь возможность удалить заявку на кредит

## Нефункциональные требования

* Использовать в разработке последнюю версию
  Java и фреимворк Spring. Для
  создания структуры базы данных
  использовать liquibase с миграцями в
  формате .yaml, а запросы выполнять
  через JdbcTemplate.
* Обрабатывать ошибки, с помощью
  ExceptionHandler.
* Прикрутить Circuit Breaker,
  который сработает при времени ответа больше 1
  секунды.

## Инструкция локального запуска проекта
1. Создайте H2 базу данных

 ![image](https://user-images.githubusercontent.com/93432684/236708581-853613c0-8577-4b26-af45-11e9f8fb8a23.png)
 
2. Установите следующие properties для базы данных

 ![image](https://user-images.githubusercontent.com/93432684/236708674-790e4248-f3d7-4120-bdc4-42e7ee7bbcd9.png)
 
3. База создана

## Дополнительный функционал

- [x] Получение тарифа по id
- [x] Добавление нового тарифа


## Ссылки

* [Задание](https://drive.google.com/file/d/1zett8xUTBs7ZuF3sFCnykGqPkwLFldb4/view)
* [Liquibase](https://www.youtube.com/watch?v=ec90flC2MNg)
* [ExceptionHandler](https://habr.com/ru/articles/528116/)
* [Scheduler](https://habr.com/ru/articles/580062/)
