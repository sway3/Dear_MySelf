let target = document.getElementById('type');

function blink() {
    target.classList.toggle('active');
}

function selectRandomText() {
    let textArr = ["유독 힘들었던 한 주가 끝났다.", "평생 잊지 못할 여행이었다.",
        "날씨가 정말 좋은 날이었다.", "여름이었다.", "오늘따라 집에 가고싶었다."];
    let selectText = textArr[Math.floor(Math.random() * textArr.length)];
    let selectTextChar = selectText.split('');

    return selectTextChar;
}

function resetText() {
    randomFont = ['Nanum Myeongjo', 'Nanum Gothic'];
    target.style.fontFamily = randomFont[Math.floor(Math.random() * randomFont.length)];
    target.textContent = "";
    dynamic(selectRandomText());
}

function dynamic(arr) {
    if(arr.length > 0) {
        target.textContent += arr.shift();
        setTimeout(function() {
            dynamic(arr);
        }, 80);
    } else {
        setTimeout(resetText, 3000);
    }
}

setInterval(blink, 500);
dynamic(selectRandomText());