# TODO
* Добавить обзоры (лайки это хорошо, но обзоры информативнее)
* Swagger теперь будет жить с нами, но стоит добавить его аннотаций для красоты

# Librarian 📚

Проект платформы для обмена мнениями о книгах с возможностью получить рекомендации для дальнейшего чтения.

## Функционал (кроме базового)
* Выборка самых популярных книг
* Получение индивидуальной рекомендации "что почитать". Рекомендация основана на сравнении лайков юзера и его друзей. Выбираются друзья со схожими лайками, выбираются книги, которые лайкали друзья и не читал пользователь.

<div>
<img width="1024" alt="Friendly robot-cat at a library" src="assets/librarian_robo_cat_orig.jpg">
</div>

## API (Swagger)
Два пути посмотреть API:
* Перейти на сайт https://editor-next.swagger.io
* импортировать файл documentation/SwaggerAPI.json

ИЛИ
* Во время работы проекта API доступно по ссылке:
http://localhost:8080/swagger-ui/index.html

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