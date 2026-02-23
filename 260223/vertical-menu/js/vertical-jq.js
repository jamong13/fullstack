$(function () {
  //   $(".m_menu li ul").css("display", "none");
  //   $('.m_menu li:first ul').css('display', 'block');
  //   $('.m_menu li:first ul').css('display', 'block');
  $(".sub").hide();
  $(".sub").eq(0).show();
  //   $('.m_menu li:nth-child(1) ul').css('display', 'block');
  //   $('.m_menu li:nth-child(1) ul').show();
  //   $('.m_menu li:eq(0) ul').show();
  //   $('.m_menu li:first ul').show();

  $(".m_menu > li > a").on("click", function (e) {
    // .m_menu 안의 li 자식인 a 클릭
    e.preventDefault(); // a 링크 금지

    var status = $(this).next(".sub").css("display");
    // 클릭한 다음에 있는 .sub의 display 상태(none/block)
    // alert(status);
    if (status === "none") {
      $(".sub").slideUp(500); // 모든 sub 닫고
      $(this).next(".sub").slideDown(500);
    } else {
      $(".sub").slideUp(500);
    }
  });
});
