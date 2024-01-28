package com.yasemin.controller;

import com.yasemin.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;
}
