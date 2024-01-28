package com.yasemin.repository;

import com.yasemin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email, String password);

    Optional<User> findByEmailAndPassword(String email, String password);

    List<User> findAllAndSortByName();

    Optional<User> findByName(String name);

    List<User> findByNameContains(String name);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE LENGTH(u.password) > ?1")
    List<User> findPasswordByLength(@Param("password") int length);

    List<User>  findAllEmailByEndsWith(String endsWith);
}
