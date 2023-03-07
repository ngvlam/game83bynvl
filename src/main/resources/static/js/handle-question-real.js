
// XỬ LÝ ĐIỂM


const startTime = Date.now();
let stop = false;
let scoreFirst = 0;
function getScore() {
    return 1000 - (Date.now() - startTime) / 15;
}

requestAnimationFrame(function updateScore() {
    const score = Math.max(getScore(), 0);
    // span.innerText = score.toFixed(0);
    // meter.value = score;

    if (score > 0 && !stop)
        requestAnimationFrame(updateScore);
    else {
        scoreFirst = score;

        console.log(answer)
        if (btnClicked.attr("data-answer") != answer || timeLeft == 0) {
            scoreFirst = 0;
        }

        let scoreTotal = parseInt(localStorage.getItem('scoreReal'))
        scoreTotal = scoreTotal + parseInt(scoreFirst);
        localStorage.setItem('scoreReal', scoreTotal.toString());


        $('#diem-cuoi-cung').text('Điểm đạt được: ' + localStorage.getItem('scoreReal'))
        // $.ajax({
        //     type: "POST",
        //     url: "/first-game-test-1",
        //     data: {scoreFirst: scoreFirst},
        //     success: function (data){},
        //
        // });
    }
});

const questionNext = $('.question-next-link')
const btnOpinion = $(".btn-opinion")

let btnClicked;
// Đếm ngược giây
timeLeft = 15;

function countdown() {
    timeLeft--;
    document.getElementById("seconds").innerHTML = String( timeLeft );
    if (timeLeft > 0 && !stop) {
        setTimeout(countdown, 1000);
    }
    else {
        questionNext.css('display', 'block')
        btnOpinion.each(function () {
            $(this).prop('disabled', true)
        })

    }

};

setTimeout(countdown, 1000);
btnOpinion.click(function () {
    stop = true;
    btnClicked = $(this)
    let luachon = localStorage.getItem('luachon')
    luachon += btnClicked.attr("data-answer") + ','
    localStorage.setItem('luachon', luachon);
    questionNext.css('display', 'block')
    $(this).addClass('active')

})

if (performance.navigation.type == performance.navigation.TYPE_RELOAD) {
    alert("Refresh browser thì câu này sẽ không được tính điểm")
    btnOpinion.each(function () {
        $(this).prop('disabled', true)
    })
    $('#lua-chon-cua-ban').after('<p class="mt-4 ml-2 text-danger">Các lựa chọn đã bị khóa do tải lại trình duyệt</p>')
    questionNext.css('display', 'block')
}

