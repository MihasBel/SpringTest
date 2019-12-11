    // navbar
$(window).scroll(function() {
    if ($(this).scrollTop() > 50){
        $('.navbar').addClass("navbar-static");

    }
    else{
        $('.navbar').removeClass("navbar-static");

    }
});
    // popup
let popup = document.querySelector('.popup');
let popupOpen = document.querySelector('.popup-open');
let popupClose = popup.querySelector('.popup-close');
popupOpen.addEventListener('click' , function () {

    popup.classList.remove('hidden');
})
    popup.addEventListener("click", function(event) {
        e = event || window.event
        if (e.target == this) {
            popup.classList.add("hidden");
        }
    });
popupClose.addEventListener('click' , function (event) {
    event.preventDefault();
    popup.classList.add('hidden');
})

addEventListener("keydown", function(event) {
    if (event.keyCode == 27)
        popup.classList.add('hidden');
});
    // кнопка к началу
var smoothJumpUp = function() {
    if (document.body.scrollTop>0 || document.documentElement.scrollTop>0) {
        window.scrollBy(0,-50);
        setTimeout(smoothJumpUp, 20);
    }
};
    $(window).scroll(function() {
        if ($(this).scrollTop() > 300){
            $('.topcontrol').addClass("show");

        }
        else{
            $('.topcontrol').removeClass("show");

        }
    });

 // anchorTop
    var smoothJumpUpFast = function() {
        if (document.body.scrollTop>0 || document.documentElement.scrollTop>0) {
            document.documentElement.scrollIntoView(true);

        }
    };
    //parallax

    function createParallax(selector) {
        $(Window).scroll(function () {
            let st = $(this).scrollTop();
            $(selector).css({
                "transform" : "translate(0%, -" + st/15 + "%"
            });
        });
    }
    createParallax(".first_parallax");
    createParallax(".secondParalla");
    createParallax(".thirdParalla");
    // Form Submit
    /*clientName, clientEmail, clientNumber, clientText*/
    $("#submitForm").click(function(event) {


        let clientName = $('#clientName').val();
        let clientEmail = $('#clientEmail').val();
        let clientNumber = $('#clientNumber').val();
        let clientText = $('#clientText').val();


        $.post("/saveClient", {
            clientName   : clientName   ,
            clientEmail   : clientEmail   ,
            clientNumber   : clientNumber   ,
            clientText   : clientText

        }, function(data) {

            //var json = JSON.parse(data);
            //...

        }).done(function(data) {
            alert("успешно отправлено!");

            //location.reload();
        }).fail(function(xhr, textStatus, errorThrown) {
        })
        event.preventDefault();

    });