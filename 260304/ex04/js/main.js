$(function () {
  var slider = $(".slick-slider")
    .on("init", function (event, slick) {
      $("#current-slide").text(slick.currentSlide + 1);
      $("#total-slides").text(slick.slideCount);
    })
    .slick({
      autoplay: true,
      arrows: false,
      dots: false,
    });
  slider.on("afterChange", function (event, slick, currentSlide) {
    $("#current-slide").text(slick.currentSlide + 1);
  });

  $(".prev").click(function (e) {
    e.preventDefault();
    slider.slick("slickPrev");
    return false;
  });

  $(".next").click(function (e) {
    e.preventDefault();
    slider.slick("slickNext");
    return false;
  });

  var isPaused = false;
  $(".pause").click(function (e) {
    e.preventDefault();
    if (!isPaused) {
      slider.slick("slickPause");
      $(this).addClass("on");
      isPaused = true;
    } else {
      slider.slick("slickPlay");
      $(this).removeClass("on");
      isPaused = false;
    }
    return false;
  });
});
