package com.yasemin.repository;

import com.yasemin.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query("Select m from Movie m where m.raiting > ?1")
    List<Movie> findAllByRaiting(@Param("raiting") Float value);

    @Query("Select m from Movie m where m.premiere< ?1")
    List<Movie> findAllByPremiere(@Param("date") String date);
    @Query("Select m from Movie m where m.raiting between ?1 and ?2")
    List<Movie> findAllByRaitingBetween(@Param("raiting") Float min, Float max);

   Optional<Movie> findByName(String name);
}
