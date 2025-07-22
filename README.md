# User API 서비스

Spring Boot 기반의 사용자 관리 API입니다. 회원 가입, 목록 조회, 상세 조회 기능을 포함하며, Docker를 통해 손쉽게 실행할 수 있습니다.

---

## 실행 방법

### Docker 실행

```bash
docker-compose up --build
```

### API 사용 예시

#### 회원가입
URL : POST /api/users/signup
```json
{
  "email": "test1@example.com",
  "password": "1234",
  "userName": "테스트유저1"
}
```

#### 회원 목록 조회
URL : GET /api/users/list
쿼리 파라미터 :
  - keyword : 정렬 기준 (userName, viewCount, createdAt)
  - asc : 정렬 순서 (오름차순, 내림차순)
  - page : 페이지 번호
```http
GET http://localhost:8080/api/users/list?keyword=userName&asc=false&page=2
```

#### 회원 상세 조회 & 조회수 증가
URL : POST /api/users/detail
```json
{
  "email": "test1@example.com"
}
```
