package com.yasemin.controller;

import com.yasemin.entity.Movie;
import com.yasemin.entity.MovieComment;
import com.yasemin.service.MovieCommentService;
import com.yasemin.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie-comment")
public class MovieCommentController {
    private final MovieCommentService movieCommentService;
    private final MovieService movieService;
    @GetMapping("/find-all-comments-by-movie-name")
    public List<MovieComment> findAllCommentsByMovieName(String movieName){
        Optional<Movie> movie = movieService.findByName(movieName);
        if(movie.isEmpty())
            throw new RuntimeException("Movie not found");
        return movieCommentService.findAllByMovieId(movie.get().getId());
    }
    @GetMapping("/find-all-comments-between-date")
    public List<MovieComment> findAllCommentsBetweenDate(String startDate, String endDate){
        return movieCommentService.findAllBetweenDate(startDate, endDate);
    }
    @GetMapping("/find-all-comments-by-comment-length")
    public List<MovieComment> findAllCommentsByCommentLength(int value){
        return movieCommentService.findAllByCommentLength(value);
    }
}
