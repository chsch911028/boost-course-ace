//[참고 블로그] https://im-developer.tistory.com/97
function Carousel(
  parentsClass = "",
  itemWidth = CAROUSEL_DEFAULT_ITEM_WITH,
  moveSpeed = CAROUSEL_DEFAULT_MOVE_SPEED
) {
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
