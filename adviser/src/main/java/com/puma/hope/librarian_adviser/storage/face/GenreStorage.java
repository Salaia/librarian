package com.puma.hope.librarian_adviser.storage.face;

import com.puma.hope.librarian_adviser.model.Genre;

import java.util.List;

public interface GenreStorage {
    List<Genre> findAll();

    Genre findGenreById(Long id);

    void checkGenreExistence(Long id);
}
