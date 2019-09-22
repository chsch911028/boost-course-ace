import { URL, PRODUCTS_API_PATH, PROMOTIONS_API_PATH } from "./Constants.js";

import Carousel from "./Carousel.js";

$(document).ready(function() {
  const BOOKING_LOING_PAGE_URL = "./bookinglogin.html";
  const MY_RESERVATION_PAGE_URL = "./myreservation.html";

  let state = {
    login: {
      isLogin: false,
      loginId: ""
    }
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
    url: `${URL}${PROMOTIONS_API_PATH}`,
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
    url: `${URL}${PRODUCTS_API_PATH}`,
    dataType: "JSON",
    success: function(data) {
      //4-1. 제품 갯수 text update
      const totalCount = data.totalCount;
      $(".event_lst_txt span").text(`${totalCount}개`);

      //더보기 UI 상태 조정
      const moreEl = document.querySelector(".more");
      if (data.items.length >= totalCount) {
        moreEl.style.display = "none";
      } else {
        moreEl.style.display = "block";
      }

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
            .replace(/{productImageUrl}/g, `/${productImageUrl}`);

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
    //5-1. 클릭된 item의 category id 가져와서 상태 저장
    const categoryId = Number(clickedEl.attr("data-category"));

    //5-2. categoryId별 요청 URL 세팅
    let url = `${URL}${PRODUCTS_API_PATH}?`;
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

        //더보기 UI 상태 조정
        const moreEl = document.querySelector(".more");
        if (data.items.length >= totalCount) {
          moreEl.style.display = "none";
        } else {
          moreEl.style.display = "block";
        }

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
              .replace(/{productImageUrl}/g, `/${productImageUrl}`);

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

  //6. 더보기 기능
  // 6-1. 클릭시 추가 데이터 4개 가져와 보여주기
  document.querySelector(".more").addEventListener("click", e => {
    e.preventDefault(); // bubbling 방지
    const eventBindedEl = e.currentTarget;
    // categoryId, productsCount 가져오기
    const categoryId = Number(
      document
        .querySelector(".event_tab_lst .item .anchor.active")
        .parentElement.getAttribute("data-category")
    );
    const productsCount = Number(
      document.querySelector(".wrap_event_box").getAttribute("products-count")
    );

    let url = `${URL}${PRODUCTS_API_PATH}?start=${productsCount}`;
    if (categoryId > 0) {
      url += `&categoryId=${categoryId}`;
    }

    $.ajax({
      type: "GET",
      url: url,
      dataType: "JSON",
      success: function(data) {
        // 6-2. 더 이상의 데이터가 없다면 더보기 UI 삭제
        const totalCount = data.totalCount;
        if (productsCount + data.items.length >= totalCount) {
          eventBindedEl.style.display = "none";
        }

        //Products Template 세팅
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
              .replace(/{productImageUrl}/g, `/${productImageUrl}`);

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

        //products-count 세팅
        document
          .querySelector(".wrap_event_box")
          .setAttribute(
            "products-count",
            `${productsCount + data.items.length}`
          );
      }
    });
  });

  //7. TOP 버튼 클릭시 위로 이동
  const linkTopEl = document.querySelector(`.lnk_top`);
  const handleClickEventOfLinkTopEl = e => {
    window.scrollTo({ top: 0, behavior: "smooth" });
  };
  linkTopEl.addEventListener("click", handleClickEventOfLinkTopEl);
});
