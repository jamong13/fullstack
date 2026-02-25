$(function () {
  var slider = $(".bxslider").bxSlider({
    auto: true,
    autoHover: true,
    pause: 3000, // 슬라이드 전체 속드
    controls: false, // 화살표 숨김
    pager: false, // 페이저 숨김
    onSlideAfter: function ($slideElement, oldIndex, newIndex) {
      $("#current-slide").text(newIndex + 1);
    },
  });
  //   총슬라이드 개수
  var totalSlides = slider.getSlideCount();
  //   슬라이드 변경시 현재 슬라이드 번호 업데이트
  $("#total-slides").text(totalSlides);

  //   다음 슬라이드
  $(".next").click(function (e) {
    e.preventDefault();
    slider.goToNextSlide();
  });
  //   이전 슬라이드
  $(".prev").click(function (e) {
    e.preventDefault();
    slider.goToPrevSlide();
  });
  //   일시정지/재생 버튼
  var isPaused = false;
  $(".pause").click(function (e) {
    e.preventDefault();
    if (!isPaused) {
      slider.stopAuto(); // 슬라이드를 정지시키는 메서드
      $(this).addClass("on");
      isPaused = true;
    } else {
      slider.startAuto();
      $(this).addClass("on");
      isPaused = true;
    }
  });
});
