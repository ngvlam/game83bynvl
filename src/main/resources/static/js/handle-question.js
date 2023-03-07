
// XỬ LÝ ĐIỂM
const span = document.getElementById("score-span"),
    meter = document.getElementById("score-meter");

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

        if (btnClicked.attr("data-answer") != "A" || timeLeft == 0) {
            scoreFirst = 0;
        }

        let scoreTotal = parseInt(localStorage.getItem('scoreTest'))
        scoreTotal = scoreTotal + parseInt(scoreFirst);
        localStorage.setItem('scoreTest', scoreTotal.toString());

        $('#diem-cuoi-cung').text('Điểm đạt được: ' + localStorage.getItem('scoreTest'))
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
const btnOpinionTest = $(".btn-opinion-test")

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
        btnOpinionTest.each(function () {
                $(this).prop('disabled', true)
        })

    }

};

setTimeout(countdown, 1000);
btnOpinionTest.click(function () {
    stop = true;
    btnClicked = $(this)
    questionNext.css('display', 'block')
    $(this).addClass('active')

})

if (performance.navigation.type == performance.navigation.TYPE_RELOAD) {
    alert("Refresh browser thì câu này sẽ không được tính điểm")
    btnOpinionTest.each(function () {
        $(this).prop('disabled', true)
    })
    questionNext.css('display', 'block')
}

