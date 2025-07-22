package com.example.report.repository;

import com.example.report.domain.QUser;
import com.example.report.domain.User;
import com.example.report.dto.UserDetailRequest;
import com.example.report.dto.UserDetailResponse;
import com.example.report.dto.UserListRequest;
import com.example.report.dto.UserListResponse;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<UserListResponse> getUserList(UserListRequest request) {
        QUser user = QUser.user;

        String keyword = request.getKeyword();
        boolean asc = request.isAsc();
        int limit = 5;
        int offset = (request.getPage() - 1) * limit;

        OrderSpecifier<?> orderSpecifier = null;
        if ("viewCount".equalsIgnoreCase(keyword)) {
            orderSpecifier = asc ? user.viewCount.asc() : user.viewCount.desc();
        } else if ("createdAt".equalsIgnoreCase(keyword)) {
            orderSpecifier = asc ? user.createdAt.asc() : user.createdAt.desc();
        } else if ("userName".equalsIgnoreCase(keyword)) {
            orderSpecifier = asc ? user.userName.asc() : user.userName.desc();
        }

        return queryFactory
                .select(Projections.constructor(
                        UserListResponse.class,
                        user.userName,
                        user.viewCount,
                        user.createdAt))
                .from(user)
                .orderBy(orderSpecifier)
                .offset(offset)
                .limit(limit)
                .fetch();
    }

    @Override
    public UserDetailResponse getUserDetail(UserDetailRequest request) {
        QUser user = QUser.user;

        User result = queryFactory
                .selectFrom(user)
                .where(user.email.eq(request.getEmail()))
                .fetchOne();

        if (result == null) {
            throw new EntityNotFoundException("유저를 찾을 수 없습니다.");
        }

        return new UserDetailResponse(
                result.getId(),
                result.getUserName(),
                result.getEmail(),
                result.getViewCount(),
                result.getCreatedAt()
        );
    }

    @Override
    public Optional<User> findByEmailWithQuerydsl(String email) {
        QUser user = QUser.user;

        return Optional.ofNullable(
                queryFactory
                        .selectFrom(user)
                        .where(user.email.eq(email))
                        .fetchOne()
        );
    }
}
