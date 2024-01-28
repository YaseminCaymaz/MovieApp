package com.yasemin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblmovie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String language;;
    String image;
    String name;
    String country;
    Double raiting;
    @Column(length = 2040)
    String summary;
    LocalDate premiere;
    String url;

    @ElementCollection
    List<Long> genres;

    @ElementCollection
    List<Long> comments;

}
