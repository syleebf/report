package com.example.report.dto;

import com.example.report.domain.User;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UserListResponse {

    private String userName;
    private Long viewCount;
    private LocalDateTime createdAt;

    @QueryProjection
    public UserListResponse(User user) {
        this.userName = user.getUserName();
        this.viewCount = user.getViewCount();
        this.createdAt = user.getCreatedAt();
    }
}
