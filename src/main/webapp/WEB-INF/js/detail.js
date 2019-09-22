import { PRODUCTS_API_PATH, FULL_SCORE } from "./Constants.js";
import Carousel from "./Carousel.js";
import {
  getQueryParamsFromUrl,
  getRequestWithPathVariable,
  renderWithArrayData,
  insertWithObjectData,
  renderWithObjectData
} from "./Util.js";

//template
import DisplayImageItem from "../template/DisplayImageItem.js";
import CommentItem from "../template/CommentItem.js";
import LocationInfo from "../template/LocationInfo.js";

window.onload = function() {
  //*** Load DOM
  const prevBtnEl = document.querySelector(`.prev`);
  const nextBtnEl = document.querySelector(`.nxt`);

  const paginationFirstNum = document.querySelector(
    `.pagination .num:nth-child(1)`
  );
  const paginationSecondNum = document.querySelector(
    `.pagination .num:nth-child(2)`
  );

  const productContentEl = document.querySelector(`.store_details .dsc`);
  const moreOpenBtnEl = document.querySelector(`.bk_more._open`);
  const moreCloseBtnEl = document.querySelector(`.bk_more._close`);

  const bkBtnEL = document.querySelector(`.bk_btn`);
  const gradeGraphValueEl = document.querySelector(
    `.grade_area .graph_mask .graph_value`
  );
  const scoreTextValueEl = document.querySelector(`.text_value`);
  const commentCountEl = document.querySelector(`.join_count em`);

  const reviewMoreBtnEl = document.querySelector(`.btn_review_more`);

  const detailInfoDesEl = document.querySelector(`.detail_info .in_dsc`);
  const linkTopEl = document.querySelector(`.lnk_top`);

  //*** Define Event Handler
  const handleClickEventOfReviewMoreBtn = e => {
    const { displayInfoId } = getQueryParamsFromUrl();
    window.location.href = `./review.html?displayInfoId=${displayInfoId}`;
  };

  //*** Add Event Listner
  reviewMoreBtnEl.addEventListener("click", handleClickEventOfReviewMoreBtn);

  //*** 실행부분
  // 1. URL Query 가져와서 HTTP GET 요청하기(/api/products/{displayInfoId})
  const params = getQueryParamsFromUrl();
  if(params.displayInfoId){
      getRequestWithPathVariable(PRODUCTS_API_PATH, params.displayInfoId).then(
          response => {
              const {
                  averageScore,
                  comments,
                  displayInfo,
                  displayInfoImage,
                  productImages,
                  productPrices
              } = response;
              const { productDescription, productContent } = displayInfo;

              //1-2. 메인 이미지("ma")를 우선적으로 포함하며, 최대 2개의 이미지를 갖는 데이터
              const images = productImages
                  .reduce((imgArr, productImage) => {
                      if (productImage.type === "ma") {
                          imgArr.unshift({
                              imgSrc: productImage.saveFileName,
                              title: productDescription
                          });
                          return imgArr;
                      }

                      if (productImage.type === "et") {
                          imgArr.push({
                              imgSrc: productImage.saveFileName,
                              title: productDescription
                          });
                          return imgArr;
                      }

                      return imgArr;
                  }, [])
                  .slice(0, 2);

              //1-3. 전시 이미지 뷰 렌더링(with images data);
              renderWithArrayData(
                  DisplayImageItem,
                  images,
                  `.visual_img.detail_swipe.carousel-list`
              );

              //1-4. 이미지 갯수가 1개이상이면, next(prev)버튼을 숨긴다.
              if (images.length < 2) {
                  prevBtnEl.style.display = "none";
                  nextBtnEl.style.display = "none";
              } else {
                  //1-5. Carousel 기능 binding
                  const productImageCarousel = new Carousel();
                  productImageCarousel.prevCallBack = () => {
                      const index = productImageCarousel.curIndex;
                      //pagination
                      paginationFirstNum.innerText = index + 1;
                      //prevBtn
                      if (index === 0) {
                          productImageCarousel.nextBtn.firstElementChild.classList.remove(
                              "off"
                          );
                          productImageCarousel.prevBtn.firstElementChild.classList.add("off");
                      }
                  };
                  productImageCarousel.nextCallBack = () => {
                      const index = productImageCarousel.curIndex;
                      //pagination
                      paginationFirstNum.innerText = index + 1;
                      //nextBtn
                      if (productImageCarousel.len === index + 1) {
                          productImageCarousel.prevBtn.firstElementChild.classList.remove(
                              "off"
                          );
                          productImageCarousel.nextBtn.firstElementChild.classList.add("off");
                      }
                  };

                  //1-6. pagination 갯수 설정
                  paginationSecondNum.innerHTML = `/ <span>${images.length}</span>`;
              }

              //2. ProductContent Text 넣기
              productContentEl.innerText = productContent;

              //3. 한줄평 평점+별색상 반영하기
              const score = averageScore.toFixed(1);
              gradeGraphValueEl.style.width = `${(score * 100) / FULL_SCORE}%`;
              scoreTextValueEl.firstElementChild.innerText = score;

              //4. 한줄평 건수 등록
              commentCountEl.innerText = comments.length;

              //5. 한줄평 내용 (최대 3개만 가져오기)
              renderWithArrayData(
                  CommentItem,
                  comments.slice(0, 3).map(comment => {
                      comment.secretEmail = comment.reservationEmail.substr(0, 4) + "****";
                      comment.hasImage = !!comment.commentImages[0];
                      comment.imgSrc =
                          comment.hasImage && comment.commentImages[0].saveFileName;
                      comment.visitDate = comment.reservationDate.split(" ")[0];
                      comment.title = productDescription;
                      comment.imgCount = comment.commentImages.length;

                      return comment;
                  }),
                  `.list_short_review`
              );

              //6. 상세정보 description 추가
              detailInfoDesEl.innerText = productContent;

              //7. 오시는길 내용 추가
              // 전시타이틀/새주소/지번주소/세부주소/전화번호 노출
              insertWithObjectData(LocationInfo, displayInfo, `.detail_location`);
          }
      );
  }


  //8. 펼처보기/접기 기능
  const handleClickEventOfMoreOpenBtn = e => {
    productContentEl.parentElement.classList.remove("close3");
    moreOpenBtnEl.style.display = "none";
    moreCloseBtnEl.style.display = "block";
  };

  const handleClickEventOfMoreCloseBtn = e => {
    productContentEl.parentElement.classList.add("close3");
    moreCloseBtnEl.style.display = "none";
    moreOpenBtnEl.style.display = "block";
  };

  moreOpenBtnEl.addEventListener("click", handleClickEventOfMoreOpenBtn);
  moreCloseBtnEl.addEventListener("click", handleClickEventOfMoreCloseBtn);

  //9. 예매하기 링크 이동 기능
  const handleClickEvnetOfBkBtn = e => {
    window.location.href = "/reserve.html";
  };
  bkBtnEL.addEventListener("click", handleClickEvnetOfBkBtn);

  //10. TOP 버튼 클릭시 위로 이동
  const handleClickEventOfLinkTopEl = e => {
    window.scrollTo({ top: 0, behavior: "smooth" });
  };
  linkTopEl.addEventListener("click", handleClickEventOfLinkTopEl);

  //11. TAB 클릭 이벤트
  const tabListEl = document.querySelectorAll(`.info_tab_lst li a`);
  const detailInfoTabEl = tabListEl[0];
  const locationInfoTabEl = tabListEl[1];

  const detailAreaWrapEl = document.querySelector(`.detail_area_wrap`);
  const detailLocationWrapEl = document.querySelector(`.detail_location`);

  const handleClickEventOfDetailInfoTab = e => {
    //anchor 가져오기
    locationInfoTabEl.classList.remove("active");
    detailInfoTabEl.classList.add("active");
    //hide 변경하기
    detailAreaWrapEl.classList.remove("hide");
    detailLocationWrapEl.classList.add("hide");
  };

  const handleClickEventOfLocationInfoTab = e => {
    //anchor 가져오기
    detailInfoTabEl.classList.remove("active");
    locationInfoTabEl.classList.add("active");
    //hide 변경하기
    detailLocationWrapEl.classList.remove("hide");
    detailAreaWrapEl.classList.add("hide");
  };

  detailInfoTabEl.addEventListener("click", handleClickEventOfDetailInfoTab);
  locationInfoTabEl.addEventListener(
    "click",
    handleClickEventOfLocationInfoTab
  );

  // hide 변경
};
