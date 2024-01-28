package com.yasemin.controller;

import com.yasemin.entity.Movie;
import com.yasemin.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/find-all-by-raiting")
    public List<Movie> findAllByRaiting(Float value){
        return movieService.findAllByRaiting(value);
    }
    @GetMapping("/find-all-by-premiere-before-date")
    public List<Movie> findAllByPremiere(String date){
        return movieService.findAllByPremiere(date);
    }
    @GetMapping("/find-all-by-raiting-between")
    public List<Movie> findAllByRaitingBetween(Float min, Float max){
        return movieService.findAllByRaitingBetween(min, max);
    }
}
