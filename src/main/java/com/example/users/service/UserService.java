package com.example.users.service;

import org.springframework.stereotype.Service;

import com.example.users.dto.UserRegisterDto;
import com.example.users.entity.UserEntity;
import com.example.users.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<UserEntity> getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
    

    public UserEntity resgister(UserRegisterDto dto) {
        // dto → entity 변환 (간단히 builder 사용)
        UserEntity user = UserEntity.builder()
                .username(dto.getUsername())
                .userId(dto.getUserId())
                .password(dto.getPassword())  // 실제론 암호화 필요
                .email(dto.getEmail())
                .build();

        return userRepository.save(user);
    }
    
    public UserEntity updateUser(Integer id, UserRegisterDto dto) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        user.setUsername(dto.getUsername());
        user.setUserId(dto.getUserId());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());

        return userRepository.save(user);
    }
    
    public UserEntity deleteUser(Integer id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        userRepository.delete(user);
        return user;
    }
    
}
