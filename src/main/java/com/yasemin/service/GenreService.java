package com.yasemin.service;

import com.yasemin.entity.Genre;
import com.yasemin.repository.GenreRepository;
import com.yasemin.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService implements ICrudService<Genre,Long> {
    private final GenreRepository genreRepository;
    @Override
    public Genre save(Genre entity) {
        return null;
    }

    @Override
    public Genre update(Genre entity) {
        return null;
    }

    @Override
    public Iterable<Genre> saveAll(Iterable<Genre> t) {
        return null;
    }

    @Override
    public Optional<Genre> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Genre delete(Genre entity) {
        return null;
    }

    @Override
    public Genre deleteById(Long aLong) {
        return null;
    }
}
