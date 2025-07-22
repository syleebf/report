package com.example.report.controller;

import com.example.report.domain.User;
import com.example.report.dto.*;
import com.example.report.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signup(@RequestBody @Valid UserSignupRequest request) {
        if (userService.isEmailExist(request.getEmail())) {
            ApiResponse response = new ApiResponse(HttpStatus.CONFLICT.value(), "이미 등록된 이메일입니다.");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }

        userService.signup(request);
        ApiResponse response = new ApiResponse(HttpStatus.OK.value(), "회원가입 성공");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 회원목록조회
    @GetMapping("/list")
    public ResponseEntity<List<UserListResponse>> getUserList(UserListRequest request) {
        List<UserListResponse> users = userService.getAllUsers(request);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/detail")
    public ResponseEntity<UserDetailResponse> getUserDetail(@RequestBody @Valid UserDetailRequest request) {
        System.out.println(request.getEmail());
        UserDetailResponse users = userService.getUserDetail(request);
        return ResponseEntity.ok(users);
    }
}
