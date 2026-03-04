$(function () {
  $(window).trigger("resize");
  //   로딩 후 최초 리사이즈를 강제로 해줌

  $(".mobile_tab").click(function () {
    if ($(".mobile_tab").hasClass("is-active")) {
      $(".mobile_nav").removeClass("active");
      $(".transparency").removeClass("active");
      $(this).removeClass("is-active");
    } else {
      $(".mobile_nav").addClass("active");
      $(".transparency").addClass("active");
      $(this).addClass("is-active");
    }
  });
  $(".transparency").click(function () {
    $(".mobile_nav").removeClass("active");
    $(".transparency").removeClass("active");
    $(".mobile_tab").removeClass("is-active");
    $(".mobile_nav .sub").css("display", "none");
    return false;
  });

  $(".mobile_nav > ul > li > a").click(function () {
    var k = $(this).next(".sub").css("display");
    // alert(k);
    if (k == "none") {
      $(".mobile_nav .sub").slideUp(300);
      $(this).next(".sub").slideDown(300);
    } else {
      $(this).next(".sub").slideUp(300);
    }
    return false;
  });
  var slider = $(".bxslider").bxSlider({
    auto: true,
    // controls: false,
  });

  $(".slider-basic").slick({
    autoplay: true,
    dots: true,
    arrows: false,
    Infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
  });
});
