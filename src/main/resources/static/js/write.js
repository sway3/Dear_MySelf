function paperChange() {
    let paper = document.getElementById("paper");
    let currentPaper = paper.value;

    switch(currentPaper) {
        case "plain":
            document.body.style.backgroundImage = "url('/img/plain.jpg')";
            break;
        case "yellow":
            document.body.style.backgroundImage = "url('/img/yellowpaper.jpg')";
            break;
        case "green":
            document.body.style.backgroundImage = "url('/img/board.jpg')";
            document.body.style.backgroundSize = "cover";
            document.body.style.backgroundRepeat = "no-repeat";
            break;
    }
}

function fontChange() {
    let font = document.getElementById('font');
    let currentFont = font.value;

    console.log(currentFont);

    switch(currentFont) {
        case "myeongjo":
            document.body.style.fontFamily = 'Nanum Myeongjo';
            document.getElementsByTagName('button')[0].style.fontFamily = 'Nanum Myeongjo';
            document.getElementsByTagName('input')[0].style.fontFamily = 'Nanum Myeongjo';
            document.getElementsByTagName('textarea')[0].style.fontFamily = 'Nanum Myeongjo';
            document.getElementsByTagName('select')[0].style.fontFamily = 'Nanum Myeongjo';
            break;
        case "gothic":
            document.body.style.fontFamily = 'Nanum Gothic';
            document.getElementsByTagName('button')[0].style.fontFamily = 'Nanum Gothic';
            document.getElementsByTagName('input')[0].style.fontFamily = 'Nanum Gothic';
            document.getElementsByTagName('textarea')[0].style.fontFamily = 'Nanum Gothic';
            document.getElementsByTagName('select')[0].style.fontFamily = 'Nanum Gothic';
            break;
        case "notosans":
            document.body.style.fontFamily = 'Noto Sans KR';
            document.getElementsByTagName('button')[0].style.fontFamily = 'Noto Sans KR';
            document.getElementsByTagName('input')[0].style.fontFamily = 'Noto Sans KR';
            document.getElementsByTagName('textarea')[0].style.fontFamily = 'Noto Sans KR';
            document.getElementsByTagName('select')[0].style.fontFamily = 'Noto Sans KR';
            break;
    }
}

document.getElementById('form').addEventListener('submit', (event) => {

    let paper = document.forms['letterForm']['name'].value;
    let font = document.forms['letterForm']['font'].value;
    let title = document.forms['letterForm']['title'].value;
    let content = document.forms['letterForm']['content'].value;

    if (paper == "" || font == "" || title == "" || content == "") {
        event.preventDefault();
        alert("글꼴, 종이, 제목, 내용을 모두 선택 또는 입력해주세요.");
    }
});

