package com.puma.hope.librarian_adviser.storage.face;
import com.puma.hope.librarian_adviser.exception.ValidationExceptionCustom;
import com.puma.hope.librarian_adviser.model.Author;

import java.util.List;

public interface AuthorStorage {

    List<Author> findAll();

    Author findById(Long id);

    Author addAuthor(Author author) throws ValidationExceptionCustom;

    Author updateAuthor(Author author) throws ValidationExceptionCustom;

    void checkAuthorExistence(Long id);

    void deleteAuthor(Long id);

}
