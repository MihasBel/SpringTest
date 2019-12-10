$(window).scroll(function() {
    if ($(this).scrollTop() > 50){
        $('.navbar').addClass("navbar-static");

    }
    else{
        $('.navbar').removeClass("navbar-static");

    }
});