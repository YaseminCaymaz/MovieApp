package com.yasemin.controller;

import com.yasemin.dto.request.LoginRequestDto;
import com.yasemin.dto.request.RegisterRequestDto;
import com.yasemin.dto.response.LoginResponseDto;
import com.yasemin.dto.response.RegisterResponseDto;
import com.yasemin.entity.User;
import com.yasemin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/find-By-Id")
    public  ResponseEntity<Optional<User>> findById(Long aLong) {
        return ResponseEntity.ok(userService.findById(aLong));
    }
    @GetMapping("/find-All")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<User> deleteById(Long aLong) {
        return ResponseEntity.ok(userService.deleteById(aLong));
    }
    //basic login
    @PostMapping("/login")
    public ResponseEntity<User> login(String email, String password) {
        return ResponseEntity.ok(userService.login(email, password));
    }
    //basic register
    @PostMapping("/register")
    public ResponseEntity<User> register(String name, String surname, String email, String password, String repassword) {
        return ResponseEntity.ok(userService.register(name, surname, email, password, repassword));
    }
    //dto register
    @PostMapping("/register-dto")
    public ResponseEntity<RegisterResponseDto> registerDto(@RequestBody RegisterRequestDto dto) {
        return ResponseEntity.ok(userService.registerDto(dto));
    }
    //dto login
    @PostMapping("/login-dto")
    public ResponseEntity<LoginResponseDto> loginDto(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(userService.loginDto(dto));
    }

    //mapper login
    @PostMapping("/login-mapper")
    public ResponseEntity<LoginResponseDto> loginMapper(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(userService.loginMapper(dto));
    }
    //mapper register
    @PostMapping("/register-mapper")
    public ResponseEntity<RegisterResponseDto> registerMapper(@RequestBody RegisterRequestDto dto) {
        return ResponseEntity.ok(userService.registerMapper(dto));
    }
    @GetMapping("find-all-short-by-name")
    public ResponseEntity<List<User>> findAllShortByName() {
        return ResponseEntity.ok(userService.findAllAndSortByName());
    }
    @GetMapping("find-by-name")
    public User findByName(String name) {
        return userService.findByName(name);
    }
    @GetMapping("find-by-name-contains")
    public List<User> findByNameContains(String name) {
        return userService.findByNameContains(name);
    }
    @GetMapping("find-by-email")
    public User findByEmail(String email) {
        return userService.findByEmail(email);
    }


}
