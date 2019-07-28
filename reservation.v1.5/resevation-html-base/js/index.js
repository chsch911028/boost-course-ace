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
});
