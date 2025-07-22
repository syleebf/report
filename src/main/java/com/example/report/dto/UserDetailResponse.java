package com.example.report.dto;

import com.example.report.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailResponse {

    private Long id;
    private String email;
    private String userName;
    private Long viewCount;
    private LocalDateTime createdAt;

    public UserDetailResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.viewCount = user.getViewCount();
        this.createdAt = user.getCreatedAt();
    }

}
