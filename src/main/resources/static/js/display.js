function cutContent() {
    let content = document.querySelectorAll(".content");

    for (let i = 0; i < content.length; i++) {
        let text = content[i].textContent;
        content[i].textContent = text.slice(0, 20) + " ...";
    }
    // let newContent = content.slice(0, 6);
    // content.textContent = newContent;
}

function bringPaper() {
    let paper = document.querySelectorAll(".paper");
    let container = document.querySelectorAll('.letter-container');

    for (let i = 0; i < paper.length; i++) {
        let paperStyle = paper[i].textContent;
        console.log(paperStyle);

        switch(paperStyle) {
            case 'plain':
                container[i].style.backgroundImage = 'url(/img/plain.jpg)';
                break;
            case 'green':
                container[i].style.backgroundImage = 'url(/img/board.jpg)';
                break;
            case 'yellow':
                container[i].style.backgroundImage = 'url(/img/yellowpaper.jpg)';
                break;
        }
    }
}

function bringFont() {
    let fonts = document.querySelectorAll('.font');
    let container = document.querySelectorAll('.letter-container');

    for (let i = 0; i < fonts.length; i++) {
        let currentFont = fonts[i].textContent;

        console.log(currentFont);

        switch(currentFont) {
            case 'myeongjo':
                container[i].style.fontFamily = 'Nanum Myeongjo';
                break;
            case 'gothic':
                container[i].style.fontFamily = 'Nanum Gothic';
                break;
            case 'notosans':
                container[i].style.fontFamily = 'Noto Sans';
                break;
        }
    }
}

cutContent();
bringPaper();
bringFont();