# boost-course-ace

## PJ3-1

### [프로젝트 관련 내용 링크](https://www.edwith.org/boostcourse-web/project/8/content/7#summary)

###[프로젝트 기획서](https://docs.google.com/presentation/d/1i2IC1yIH5ACFCvCH4EMVv_3Zw2oltRvHK94amyNEKbs/edit#slide=id.p9)

**웹프론트엔드 기술요구사항**

- DOMContentloaded 이후에 모든 자바스크립트 로직이 동작하게 합니다.

- 상단영역의 애니메이션은 CSS3의 transition과 transform 속성을 활용해서 구현해야 합니다.

- TABUI로 구성되는 카테고리 아이템이 노출되는 영역의 HTML은 카테고리별로 각각 만들지 않고 하나로 만들어 재사용합니다.

- 카테고리 탭을 선택할 때마다, Ajax 요청을 해서 데이터를 가져와야 합니다.

- 탭 메뉴 (전시/뮤지컬/콘서트 등)는 Event delegation으로 구현합니다.

- Template 코드를 javascript 함수 안에 보관하지 않고, 별도 분리시켜서 사용해야 합니다. (HTML에 script태그 안에 보관한다던가)

- 함수 하나에 여러 개의 기능을 넣지 않고, 함수를 여러 개로 분리합니다.

**프론트엔드 Todo**

### 메인페이지 기능

- [x] 기본으로 주어진 HTML과 CSS 연결하기

- [x] 1.1 홈: 예약이미지를 클릭하며 아무런 반응이 없다.

- [x] 모든 하위페이지에서 동일하게 적용한다.

- [x] 1.2 예약확인: 비회원로그인 된 이메일정보를 보여준다.

- [x] 클릭 시 나의예약확인 페이지로 이동한다.

- [x] 로그인 안된 상태라면, ‘예약확인'으로 노출한다.

- [x] 2.1 프로모션 영역: 슬라이딩기능이미지

- [x] (type = ‘th’)를 순차적으로 노출

- [x] 끝까지 가면 다시 되돌아와서 처음 내용이 노출되며 자동슬라이딩이 된다.

- [x] (무한슬라이딩효과)슬라이딩은 좌측으로 이동되며, 이동되는 것이 보인다.

- [x] 3 카테고리: 화면이 노출될때 처음엔 ‘전체리스트' 항목이 노출된다.

- [x] 노출되는 아이템 갯수는 기본 4개다.

- [x] 카테고리내 장르를 선택하면 화면이동 없이 해당 장르 결과가 ‘5’ 영역(결과 영역)에 노출한다.

- [x] 선택된 장르 메뉴는 녹색으로 하이라이트 된다.

- [x] 4 카테고리: 장르별 노출가능한 아이템 총 갯수를 노출한다.

- [x] 5 카테고리 결과: 선택된 장르에 맞는 결과를 노출

- [x] 각 아이템별로 썸네일이미지 (type = ‘th’), 제목, 장소, 설명을 노출한다

- [x] 아이템을 선택하면(클릭) 상세페이지로 이동한다.

- [x] 6 더보기: 더보기를 누르면 추가 데이터를 가져오고 그 결과가 화면에 노출된다.

- [x] 4개씩 추가된다.

- [x] 추가로 보여줄 데이터가 없다면 더보기UI는 사라진다.

- [x] 7 TOP: TOP영역이 선택되면, 화면 맨 위로 이동한다.

### 상세 페이지 기능

### 예약하기 페이지 기능

### 나의 예매 내역확인 페이지 기능

### 한 줄 평 등록 페이지 기능

**웹백엔드 기술요구사항**

- 제공된 SQL을 이용해서 테이블을 생성하고, 샘플데이터를 입력합니다.

- maven을 이용해서 웹 어플리케이션 프로젝트를 작성합니다.

- 학습했던 것처럼 controller,service,dao로 레이어드 아키텍쳐를 구성합니다.

- spring JDBC를 이용하여 주어진 테이블로부터 입력, 수정, 삭제, 조회하는 DAO와 DTO를 작성합니다.

- 서비스 인터페이스를 작성하고 해당 서비스 인터페이스에 비지니스 메소드를 작성합니다.

- 서비스 인터페이스를 구현하는 클래스를 작성합니다.

- 해당 구현 클래스의 메소드에 적절한 트랜잭션에 관련된 애노테이션을 사용합니다.

- 클라이언트에게 Web API를 제공하기 위해 RestController 를 작성합니다.

## 백엔드 Todo

- [x] maven 프로젝트 생성

- [x] MySQL 사용자 계정 생성

- [x] ddl.sql 실행하여 테이블 생성

- [x] dml.sql 실행하여 샘플 데이터 추가

- [x] sample 이미지가 있는 압축파일인 img.zip을 webapp 폴더에 압축 해제

- [x] Spring MVC, Spring JDBC를 사용하기 위한 Spring 설정 파일 작성

- [x] DTO, Controller, Service, Repository를 알맞게 작성

- [x] 카테고리 목록 구하기 API 구현

- [x] 상품 목록 구하기 API 구현

- [x] 프로모션 정보 구하기 API 구현

### 데이터 베이스 테이블 구성

1. 제품

2. 제품 가격

3. 제품 이미지

4. 예약 정보

5. 예약 유저 평가

6. 예약 유저 평가 이미지

7. 프로모션

8. 카테고리

9. 디스플레이 정보

10. 파일 정보

### PJ3 학습 내용

1. Spring

### 프로젝트를 통해 배운 내용 정리

**1. Emmet(Zen Coding)**

- HTML 생산성 향상

- [Emmet cheet sheet](https://docs.emmet.io/cheat-sheet/)

**2. Swagger**

- API 문서 자동화

- [참고자료](https://docs.google.com/presentation/d/1i2IC1yIH5ACFCvCH4EMVv_3Zw2oltRvHK94amyNEKbs/edit#slide=id.p9)

**3. :before & :after 키워드**

- ::before & ::after 와 같은 기능을 한다.(상위 브라우저)

- 엘리먼트의 자식요소의 앞,뒤에 추가 작업을 진행할때 사용

- [참고자료](<[http://blog.hivelab.co.kr/%EA%B3%B5%EC%9C%A0before%EC%99%80after-%EA%B7%B8%EB%93%A4%EC%9D%98-%EC%A0%95%EC%B2%B4%EB%8A%94/](http://blog.hivelab.co.kr/공유before와after-그들의-정체는/)>)

**4. CSS transition & transform & carousel + pagination**

- transition: 애니메이션 효과를 반영함

- transform: 엘리먼트를 변화시킴

  - translate3d: x,y,z 축으로 이동시킴

  - **주의!** translate3d를 여러번 하는 경우 움직인 위치에서 다시 움직이지만, 기준은 본래 위치임!

  - sclae: 크기를 변화시킴

- [Carousel 참고자료](https://im-developer.tistory.com/97)

**5. Javascript Dom Handling Method**

- classList

- classList.remove

- classList.add

- querySelector

-
