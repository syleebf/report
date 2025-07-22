package com.example.report.repository;

import com.example.report.domain.User;
import com.example.report.dto.UserDetailRequest;
import com.example.report.dto.UserDetailResponse;
import com.example.report.dto.UserListRequest;
import com.example.report.dto.UserListResponse;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<User> findByEmailWithQuerydsl(String email);

    List<UserListResponse> getUserList(UserListRequest request);

    UserDetailResponse getUserDetail(UserDetailRequest request);

}
