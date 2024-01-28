package com.yasemin.entity;

import com.yasemin.utility.EStatus;
import com.yasemin.utility.EUserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbluser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 50)
    String name;
    @Column(length = 50)
    String surname;
    @Email
    @Column(length = 50)
    String email;
    @Column(length = 15)
    String phone;
    @Size(max = 32)
    String password;
    @Size(max = 32)
    String repassword;

    @ElementCollection
    List<Long> favMovies;

    @ElementCollection
    List<Long> favGenres;

    @ElementCollection
    List<Long> comments;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    EUserType userType=EUserType.USER;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    EStatus status=EStatus.PENDING;
}
