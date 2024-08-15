# TODO
* Добавить обзоры (лайки это хорошо, но обзоры информативнее)
* что-то API становится длинноват для ReadMe, освой Swagger? все говорят, он простой.

# Librarian 📚

Проект платформы для обмена мнениями о книгах с возможностью получить рекомендации для дальнейшего чтения.

## Функционал (кроме базового)
* Выборка самых популярных книг
* Получение индивидуальной рекомендации "что почитать". Рекомендация основана на сравнении лайков юзера и его друзей. Выбираются друзья со схожими лайками, выбираются книги, которые лайкали друзья и не читал пользователь.

<div>
<img width="1024" alt="Friendly robot-cat at a library" src="assets/librarian_robo_cat_orig.jpg">
</div>

## API (tested)
Users:
* POST /users - создание пользователя
* PUT /users - редактирование пользователя
* GET /users - получение списка всех пользователей
* GET /users/{id} - получение данных о пользователе по id
* PUT /users/{id}/friends/{friendId} — добавление в друзья
* DELETE /users/{id}/friends/{friendId} — удаление из друзей
* GET /users/{id}/friends — возвращает список друзей
* GET /users/{id}/friends/common/{otherId} — возвращает список друзей, общих с другим пользователем
* GET /users/{id}/recommendations — индивидуальные рекомендации. Возвращает перечень книг, 
отлайканых друзьями со схожими вкусами, но которые пользователь не читал

 Books:
* POST /books - создание книги
* PUT /books - редактирование книги
* GET /books - получение списка всех книг
* GET /books/{id} - получение книги по id
* PUT /books/{id}/like/{userId} — поставить лайк книге
* DELETE /books/{id}/like/{userId} — удалить лайк книги
* GET /books/popular?count={count} — возвращает список из первых count книг по количеству лайков. 
Если значение параметра count не задано, возвращает первые 10

 Genres:
* GET /genres - получение списка всех жанров
* GET /genres/{id} - получение жанра по id

Authors:
* POST /authors - создание автора
* PUT /authors - редактирование автора
* GET /authors - получение списка всех авторов
* GET /authors/{id} - получение автора по id
* DELETE /authors/{id} — удалить автора


## 🛠 Tech & Tools

<div>
      <img src="https://github.com/Salaia/icons/blob/main/green/Java.png?raw=true" title="Java" alt="Java" height="40"/>
      <img src="https://github.com/Salaia/icons/blob/main/green/SPRING%20boot.png?raw=true" title="Spring Boot" alt="Spring Boot" height="40"/>
      <img src="https://github.com/Salaia/icons/blob/main/green/Maven.png?raw=true" title="Apache Maven" alt="Apache Maven" height="40"/>
    <img src="https://github.com/Salaia/icons/blob/main/green/JDBC.png?raw=true" title="JDBC" alt="JDBC" height="40"/>
<img src="https://github.com/Salaia/icons/blob/main/green/PostgreSQL.png?raw=true" title="PostgreSQL" alt="PostgreSQL" height="40"/>
<img src="https://github.com/Salaia/icons/blob/main/green/Postman.png?raw=true" title="Postman" alt="Postman" height="40"/>
</div>

## Testing
Я тестирую через Постман (тесты в папке postman). Гонять коллекцией, они не изолированы!

NB: если надо отдебажить огромный SQL-запрос (как рекомендации по лайкам), на помощь придёт слоник. 
Его не надо останавливать, как бобра, можно создавать нужные сущности в Postman 
при запущенных IDEA+PGAdmin, слоник хорошо показывает, в какой точке кака. 
Прям в точке, а не "где-то рядом", еще и комментирует, что не так!

## Планы по развитию
* Мне удобнее держать в файлах Notes.txt, разбросанных по проекту. 
* Или могут висеть TODO внутри классов.

* Из глобального по техстаку: мне будет интересно попробовать, 
смогут ли ужиться 2 модуля, обращающиеся к одной базе, 
 но чтобы один был на JDBC, а другой - Hibernate. В моем представлении должны ужиться...
* Докер нужно будет прикрутить