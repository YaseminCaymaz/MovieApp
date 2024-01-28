package com.yasemin.repository;

import com.yasemin.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieCommentRepository extends JpaRepository<MovieComment,Long> {
    
    @Query("SELECT m FROM MovieComment m WHERE m.date BETWEEN ?1 AND ?2")
    Optional<List<MovieComment>> findAllBetweenDate(@Param("date") String startDate, String endDate);
    @Query("SELECT m FROM MovieComment m WHERE LENGTH(m.comment) > ?1")
    Optional<List<MovieComment>> findAllByCommentLength(@Param("comment") int value);

    Optional<List<MovieComment>> findAllByMovieId(Long id);
}
