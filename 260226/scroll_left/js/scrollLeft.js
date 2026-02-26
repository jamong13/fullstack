$(document).ready(function () {
  let sectionWidth = $(window).width();

  $(".container > section").mousewheel(function (event, delta) {
    event.preventDefault();

    let currentIndex = $(this).index();
    let targetIndex;

    if (delta > 0) {
      targetIndex = currentIndex - 1;
    } else {
      targetIndex = currentIndex + 1;
    }

    if (targetIndex >= 0 && targetIndex <= 3) {
      let scrollPosition = targetIndex * sectionWidth;
      $("html, body").stop().animate({ scrollLeft: scrollPosition }, 1000);
    }
  });
});
