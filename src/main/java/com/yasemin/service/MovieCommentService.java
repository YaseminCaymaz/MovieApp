package com.yasemin.service;

import com.yasemin.entity.MovieComment;
import com.yasemin.repository.MovieCommentRepository;
import com.yasemin.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCommentService implements ICrudService<MovieComment,Long> {
    private final MovieCommentRepository movieCommentRepository;
    @Override
    public MovieComment save(MovieComment entity) {
        return null;
    }

    @Override
    public MovieComment update(MovieComment entity) {
        return null;
    }

    @Override
    public Iterable<MovieComment> saveAll(Iterable<MovieComment> t) {
        return null;
    }

    @Override
    public Optional<MovieComment> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<MovieComment> findAll() {
        return null;
    }

    @Override
    public MovieComment delete(MovieComment entity) {
        return null;
    }

    @Override
    public MovieComment deleteById(Long aLong) {
        return null;
    }

    public List<MovieComment> findAllByMovieId(Long id) {
        Optional<List<MovieComment>> movieCommentList=movieCommentRepository.findAllByMovieId(id);
        if (movieCommentList.isEmpty())
            throw new RuntimeException("There is no comment for movie with id "+id);
        return movieCommentList.get();
    }

    public List<MovieComment> findAllBetweenDate(String startDate, String endDate) {
        Optional<List<MovieComment>> movieCommentList=movieCommentRepository.findAllBetweenDate(startDate,endDate);
        if (movieCommentList.isEmpty())
            throw new RuntimeException("There is no comment between "+startDate+" and "+endDate);
        return movieCommentList.get();
    }

    public List<MovieComment> findAllByCommentLength(int value) {
        Optional<List<MovieComment>> movieCommentList=movieCommentRepository.findAllByCommentLength(value);
        if (movieCommentList.isEmpty())
            throw new RuntimeException("There is no comment with length "+value);
        return movieCommentList.get();
    }
}
