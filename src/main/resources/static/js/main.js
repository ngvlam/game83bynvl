var playerName = $('.player-name')
var btnPlay = $('.play-game-btn')
const formPlayer = $("#formPlayer")
const name1 = $("#name1")
const name2 = $("#name2")
let isSelectName = false;

$('#td').click(function () {
    $('#name1').prop('disabled', false)
    $('#name2').prop('disabled', true)
})

$('#pt').click(function () {
    $('#name2').prop('disabled', false)
    $('#name1').prop('disabled', true)
})
// HOME PAGE
function handlePlayerClick() {
    return function () {
        $('.player-name.active').removeClass("active")

        $(this).addClass("active")
        $('.box-name .error').css("display", "none")
        isSelectName = true;
        if ($(this).hasClass('deo-phai')) {
           if($('#diff-name').children().length <= 0) {
               name1.prop('disabled', true)
               name2.prop('disabled', true)
               $('#diff-name').append('<p  id="nameKhac"><input type="text" name="name" placeholder="Thế bạn tên gì???"  required style="padding: 10px; font-weight: bold"></p>')
           }

        }
        else {
            $("#nameKhac").remove();
        }
    };
}


function checkSelectedName(e) {
    if (!isSelectName ) {
        e.preventDefault()
        $('.box-name .error').css("display", "block")
    }
}

playerName.click(handlePlayerClick())
btnPlay.click(function (e) {
    checkSelectedName(e);
})

$('#lua-chon-cua-ban')
