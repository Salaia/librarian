package com.puma.hope.librarian_adviser.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.puma.hope.librarian_adviser.model.Genre;
import com.puma.hope.librarian_adviser.storage.face.GenreStorage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreStorage genreStorage;

    public List<Genre> findAll() {
        return genreStorage.findAll();
    }

    public Genre findGenreById(Long id) {
        genreStorage.checkGenreExistence(id);
        return genreStorage.findGenreById(id);
    }
}
