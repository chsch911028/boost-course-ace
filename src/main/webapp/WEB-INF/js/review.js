import {
  getRequestWithPathVariable,
  getQueryParamsFromUrl,
  renderWithArrayData
} from "./Util.js";
import { PRODUCTS_API_PATH, FULL_SCORE } from "./Constants.js";

//Template
import CommentItem from "../template/CommentItem.js";

window.onload = function() {
  // *** Load DOM
  const gradeGraphValueEl = document.querySelector(
    `.grade_area .graph_mask .graph_value`
  );
  const scoreTextValueEl = document.querySelector(`.text_value`);
  const commentCountEl = document.querySelector(`.join_count em`);

  const params = getQueryParamsFromUrl();
  getRequestWithPathVariable(PRODUCTS_API_PATH, params.displayInfoId).then(
    response => {

      const { averageScore, comments, displayInfo } = response;
      const { productDescription } = displayInfo;

      //1. 평점/ 별색상 반영하기
      const score = averageScore.toFixed(1);
      gradeGraphValueEl.style.width = `${(score * 100) / FULL_SCORE}%`;
      scoreTextValueEl.firstElementChild.innerText = score;

      //2. 한줄평 건수 등록
      commentCountEl.innerText = comments.length;

      //3. 한줄평 렌더링
      renderWithArrayData(
        CommentItem,
        comments.map(comment => {
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
    }
  );
};
