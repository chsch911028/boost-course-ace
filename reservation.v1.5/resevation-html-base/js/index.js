$(document).ready(function() {
  const BOOKING_LOING_PAGE_URL = "./bookinglogin.html";
  const MY_RESERVATION_PAGE_URL = "./myreservation.html";

  let state = {
    login: {
      isLogin: false,
      loginId: ""
    }
  };

  function Carousel(parentsClass = "", itemWidth = 414, moveSpeed = 500) {
    this.list = document.querySelector(`${parentsClass}.carousel-list`);
    this.items = document.querySelectorAll(`${parentsClass}.carousel-item`);
    this.nextBtn = document.querySelector(`${parentsClass}.carousel-next-btn`);
    this.prevBtn = document.querySelector(`${parentsClass}.carousel-prev-btn`);

    this.len = this.items.length;
    this.moveSpeed = moveSpeed;
    this.itemWidth = itemWidth;
    this.curIndex = 0;

    //carousel list width 설정
    this.list.style.width = `${itemWidth * (this.len + 2)}px`;

    //first and last 엘리먼트 복사
    this.clonedFirst = this.list.firstElementChild.cloneNode(true);
    this.clonedLast = this.list.lastElementChild.cloneNode(true);

    // carouse list 앞뒤에 복사한 엘리먼트 추가(무한 슬라이딩 기능)
    this.list.insertBefore(this.clonedLast, this.list.firstElementChild);
    this.list.appendChild(this.clonedFirst);
    this.list.style.transform = `translate3d(-${itemWidth *
      (this.curIndex + 1)}px, 0px, 0px)`;

    this.curItem = this.items[this.curIndex];
    this.curItem.classList.add("carousel-show");

    /** Next Button Event */
    if (this.nextBtn) {
      this.nextBtn.addEventListener("click", function() {
        this.next();
      });
    }

    /** Prev Button Event */
    if (this.prevBtn) {
      this.prevBtn.addEventListener("click", function() {
        this.prev();
      });
    }
  }

  Carousel.prototype.next = function() {
    // carousel-list를 왼쪽으로 이동시킴
    if (this.curIndex <= this.len - 1) {
      this.list.style.transitionDuration = this.moveSpeed + "ms";
      this.list.style.transform = `translate3d(-${this.itemWidth *
        (this.curIndex + 2)}px, 0px, 0px)`;
    }
    //마지막 아이템에 도달한 경우
    if (this.curIndex === this.len - 1) {
      //애니메이션 없이 처음 아이템 자리로 이동시킴
      setTimeout(() => {
        this.list.style.transitionDuration = "0ms";
        this.list.style.transform = `translate3d(-${this.itemWidth}px, 0px, 0px)`;
      }, this.moveSpeed);
      //아래서 Index가 증가하기 때문에 선처리
      this.curIndex = -1;
    }

    //방금전 item에서 carousel-show 클래스 삭제
    //새롭게 현재 item 설정
    //새로운 item에 carousel-show 클래스 부여
    this.curItem.classList.remove("carousel-show");
    this.curItem = this.items[++this.curIndex];
    this.curItem.classList.add("carousel-show");
  };

  Carousel.prototype.prev = function() {
    // carousel-list를 오른쪽으로 이동시킴
    if (this.curIndex >= 0) {
      this.list.style.transitionDuration = this.moveSpeed + "ms";
      this.list.style.transform = `translate3d(-${this.itemWidth *
        this.curIndex}px, 0px, 0px)`;
    }
    //마지막 아이템에 도달한 경우
    if (this.curIndex === 0) {
      //애니메이션 없이 마지막 아이템 자리로 이동시킴
      setTimeout(() => {
        this.list.style.transitionDuration = "0ms";
        this.list.style.transform = `translate3d(-${this.itemWidth *
          this.len}px, 0px, 0px)`;
      }, this.moveSpeed);
      //아래서 Index가 증가하기 때문에 선처리
      this.curIndex = this.len;
    }

    //방금전 item에서 carousel-show 클래스 삭제
    //새롭게 현재 item 설정
    //새로운 item에 carousel-show 클래스 부여
    this.curItem.classList.remove("carousel-show");
    this.curItem = this.items[--this.curIndex];
    this.curItem.classList.add("carousel-show");
  };

  Carousel.prototype.auto = function(slideTime = 1000) {
    if (slideTime < 1000) {
      slideTime = 1000;
    }
    setInterval(() => {
      this.next();
    }, slideTime);
  };

  //1. 네이버 로고, 예약 버튼 클릭시 반응 없애기
  $(".lnk_logo").click(function(e) {
    e.preventDefault();
  });

  //2. Login 여부에 따라 GNB 상단 우측 상태변환
  if (state.login.isLogin) {
    $(".viewReservation").text(state.login.loginId);
    $(".btn_my").attr("href", MY_RESERVATION_PAGE_URL);
  }

  //3. 프로모션 영역 슬라이딩 이미지 기능
  //3-1. Promotion API로 데이터 가져오기
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/promotions",
    dataType: "JSON",
    success: function(data) {
      //3-2. Promotion Template 세팅
      let carouselItemListTemp = "";
      let carouselItemTemp = document.querySelector("#template-carousel-item")
        .innerHTML;

      if (data.items.length) {
        data.items.forEach(item => {
          carouselItemListTemp += carouselItemTemp.replace(
            "{img}",
            `../../${item.productImageUrl}`
          );
        });
      }
      document.querySelector(".carousel-list").innerHTML = carouselItemListTemp;

      //3-3. Carousel 기능 binding
      let promotionCarousel = new Carousel();
      promotionCarousel.auto();
    }
  });

  //4. 전체리스트 init
  //4-1. Products api 가져오기
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/api/products",
    dataType: "JSON",
    success: function(data) {
      //4-1. 제품 갯수 text update
      const totalCount = data.totalCount;
      $(".event_lst_txt span").text(`${totalCount}개`);

      //4-2. Products Template 세팅
      const productlItemTemp = document.querySelector("#template-product-item")
        .innerHTML;
      let flag = true;
      let productItemsLeftHTML = "";
      let productItemsRightHTML = "";

      if (data.items.length) {
        data.items.forEach((item, index) => {
          const {
            displayInfoId,
            placeName,
            productContent,
            productDescription,
            productId,
            productImageUrl
          } = item;

          const productItem = productlItemTemp
            .replace(/{displayInfoId}/g, displayInfoId)
            .replace(/{placeName}/g, placeName)
            .replace(/{productContent}/g, productContent)
            .replace(/{productDescription}/g, productDescription)
            .replace(/{productId}/g, productId)
            .replace(/{productImageUrl}/g, `../../${productImageUrl}`);

          if (flag) {
            productItemsLeftHTML += productItem;
          } else {
            productItemsRightHTML += productItem;
          }
          flag = !flag;
        });
      }

      //left
      document
        .querySelector(".lst_event_box:nth-child(1)")
        .insertAdjacentHTML("beforeend", productItemsLeftHTML);
      //right
      document
        .querySelector(".lst_event_box:nth-child(2)")
        .insertAdjacentHTML("beforeend", productItemsRightHTML);

      //4-3. products-count 세팅
      document
        .querySelector(".wrap_event_box")
        .setAttribute("products-count", `${data.items.length}`);
    }
  });

  //5. Event Tab 클릭시, 상품 초기화, 관련 이벤트 아이템 4개 보여주기, 녹색으로 링크 active 처리
  $(".event_tab_lst.tab_lst_min .item").click(function(e) {
    const clickedEl = $(this);
    //5-1. 클릭된 item의 category id 가져오기
    const categoryId = Number(clickedEl.attr("data-category"));

    //5-2. categoryId별 요청 URL 세팅
    let url = `http://localhost:8080/api/products?`;
    if (categoryId > 0) {
      url += `categoryId=${categoryId}`;
    }

    //5-3. Products By categoryId 데이터 받아오기
    $.ajax({
      type: "GET",
      url: url,
      dataType: "JSON",
      success: function(data) {
        //5-4. 제품 갯수 text update
        const totalCount = data.totalCount;
        $(".event_lst_txt span").text(`${totalCount}개`);

        //5-5. Products Template 세팅
        const productlItemTemp = document.querySelector(
          "#template-product-item"
        ).innerHTML;
        let flag = true;
        let productItemsLeftHTML = "";
        let productItemsRightHTML = "";

        if (data.items.length) {
          data.items.forEach((item, index) => {
            const {
              displayInfoId,
              placeName,
              productContent,
              productDescription,
              productId,
              productImageUrl
            } = item;

            const productItem = productlItemTemp
              .replace(/{displayInfoId}/g, displayInfoId)
              .replace(/{placeName}/g, placeName)
              .replace(/{productContent}/g, productContent)
              .replace(/{productDescription}/g, productDescription)
              .replace(/{productId}/g, productId)
              .replace(/{productImageUrl}/g, `../../${productImageUrl}`);

            if (flag) {
              productItemsLeftHTML += productItem;
            } else {
              productItemsRightHTML += productItem;
            }
            flag = !flag;
          });
        }

        //left
        document.querySelector(
          ".lst_event_box:nth-child(1)"
        ).innerHTML = productItemsLeftHTML;
        //right
        document.querySelector(
          ".lst_event_box:nth-child(2)"
        ).innerHTML = productItemsRightHTML;

        //5-6. products-count 세팅
        document
          .querySelector(".wrap_event_box")
          .setAttribute("products-count", `${data.items.length}`);
      }
    });

    //5-7. 이전 anchor active 삭제
    $(".event_tab_lst.tab_lst_min .anchor.active").removeClass("active");
    //새로 클릭된 item anchor active 추가
    clickedEl.children(".anchor").addClass("active");
  });
});
