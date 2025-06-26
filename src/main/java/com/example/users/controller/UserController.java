package com.example.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.users.dto.LogInDto;
import com.example.users.dto.UserRegisterDto;
import com.example.users.entity.UserEntity;
import com.example.users.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 전체 회원 목록 조회
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    // ID(PK) 기준 단일 회원 조회
    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
    
    // 회원가입
    @PostMapping("/resgister")
    public UserEntity resgister(@RequestBody UserRegisterDto dto) {
        return userService.resgister(dto);
    }
    
    // 로그인
    @PostMapping("/login")
    public UserEntity login(@RequestBody LogInDto dto) {
        return userService.login(dto);
    }
    // 회원 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id, @RequestBody UserRegisterDto dto) {
        UserEntity updatedUser = userService.updateUser(id, dto);
        return ResponseEntity.ok(updatedUser);
    }
    
    //회원 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable Integer id) {
        UserEntity deleteUser = userService.deleteUser(id);
        return ResponseEntity.ok(deleteUser);
    }
    // push test
    
}
