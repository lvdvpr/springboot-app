# springboot-app
* spring boot로 생성한 프로젝트
* application.yml 설정파일을 사용
* spring-boot-starter-web, mybatis-spring-boot-starter, spring-boot-devtools, ojdbc8, lombok, spring-boot-starter-test 라이브러리 의존성 추가
* spring-boot-starter-security, spring-security-taglib, spring-security-test 라이브러리 의존성 추가
* tomcat-embed-jasper, jstl 라이브러리 의존성 추가 (jsp 사용시 필요한 라이브러리 의존성)
* 특징 
  - 회원가입시 사용자 비밀번호가 암호화되어 저장된다.
  - 로그인 페이지만 제공하고, 로그인 처리는 spring-security가 수행한다.
  - 인증되지 않은 사용자는 홈, 회원가입, 로그인만 접근이 허용된다. 
  - 인증된 사용자는 게시판을 이용할 수 있다. 
    * ROLE_GUEST 권한을 가진 사용자는 게시판 목록, 상세정보, 댓글 작성, 댓글 삭제가 가능하다. 
    * ROLE_USER 권한을 가진 사용자는 게시판 목록, 상세정보, 게시글 등록, 게시글 삭제, 댓글 작성, 댓글 삭제가 가능하다.
  - ROLE_USER 권한을 가진 사용자는 정보를 이용할 수 있다.
    * 사용자 상세정보, 비밀번호 변경, 탈퇴가 가능하다.
  - ROLE_ADMIN 권한을 가진 사용자는 관리자 기능을 이용할 수 있다.  
