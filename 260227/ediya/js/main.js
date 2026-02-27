$(function () {
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
