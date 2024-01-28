package com.yasemin.service;

import com.yasemin.entity.Movie;
import com.yasemin.repository.MovieRepository;
import com.yasemin.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MovieService implements ICrudService<Movie,Long> {
    private final MovieRepository movieRepository;
    @Override
    public Movie save(Movie entity) {
        return null;
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> t) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Movie delete(Movie entity) {
        return null;
    }


    @Override
    public Movie deleteById(Long aLong) {
        return null;
    }
    public Optional<Movie> findByName(String name){
        return movieRepository.findByName(name);
    }

    public List<Movie> findAllByRaiting(Float value) {
        return movieRepository.findAllByRaiting(value);
    }

    public List<Movie> findAllByPremiere(String date) {
        return movieRepository.findAllByPremiere(date);
    }

    public List<Movie> findAllByRaitingBetween(Float min, Float max) {
        return movieRepository.findAllByRaitingBetween(min,max);
    }
}
