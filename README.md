# JSP 프로젝트

## TDD를 통한 설계
- 의존성 추가(pom.xml)
  - jUnit5
  - mockito
  - maven-sure-fire plugin
  - servlet-api
  - servlet.jsp-api
  - jstl implementation
  - lombok
- Tomcat10 서버 설정
- 회원 가입 기능 설계(JoinService)
  - models/member/JoinService.java
  - 필수 항목 검증(아이디,비밀번호,비밀번호 확인,회원명,이메일,회원가입 약관 동의)
  - 아이디(6자리 이상),비밀번호(8자리 이상) 자리수 체크
  - 비밀번호와 비밀번호 확인 입력 데이터 일치 여부 체크
  - 아이디 중복 여부 체크(중복된 경우 가입 불가)
  - 회원 정보를 저장
- 로그인 기능 설계(LoginService)
  - models/member/LoginService.java
  - 필수 항목 검증(아이디, 비밀번호)
  - 아이디에 해당하는 회원 정보가 있는지 확인
  - 로그인 처리(세션에 회원 정보를 저장)

## 기능 통합
  - 회원가입
    - Controller: /member/join
      - controllers/member/JoinController
      - GET: 회원가입 양식
      - POST: 회원가입 처리
    - View: /WEB-INF/templates/member/join.jsp
  - 로그인
    - Controller: /member/login
      - controllers/member/LoginController.java
      - GET: 로그인 양식
      - POST: 로그인 처리
    - View: /WEB-INF/templates/member/login.jsp
  - 메인 페이지
    - 로그인한 경우: '사용자명(아이디)님 로그인' 메세지 출력
      - 로그아웃(/member/logout), 마이페이지(/mypage) 링크
    - 미로그인 상태
      - 회원가입(/member/join), 로그인(/member/login) 링크
  - 로그아웃
    - Controller: /member/logout
      - controllers/member/LogoutController
      - GET,POST 메서드 상관없이 기능할 수 있도록 처리
## 기능 완성 화면
### 회원가입
![회원가입](https://raw.githubusercontent.com/leejinsol234/jsp_project/Description/imgs/join.jpg)
### 로그인
![로그인](https://raw.githubusercontent.com/leejinsol234/jsp_project/Description/imgs/login.jpg)
### 메인페이지
![메인페이지](https://raw.githubusercontent.com/leejinsol234/jsp_project/Description/imgs/main.jpg)