package com.example.report.service;

import com.example.report.domain.User;
import com.example.report.dto.*;
import com.example.report.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean isEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    public void signup(UserSignupRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUserName(request.getUserName());
        userRepository.save(user);
    }

    public List<UserListResponse> getAllUsers(UserListRequest request) {
        return userRepository.getUserList(request);
    }

    @Transactional
    public UserDetailResponse getUserDetail(UserDetailRequest request) {

        UserDetailResponse users = userRepository.getUserDetail(request);
        User user = userRepository.findByEmailWithQuerydsl(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        user.increaseViewCount();
        userRepository.save(user);

        return new UserDetailResponse(user);
    }
}
