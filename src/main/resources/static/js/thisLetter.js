function bringPaper() {
    let paper = document.querySelectorAll(".paper");

    for (let i = 0; i < paper.length; i++) {
        let paperStyle = paper[i].textContent;
        console.log(paperStyle);

        switch(paperStyle) {
            case 'plain':
                document.body.style.backgroundImage = 'url(/img/plain.jpg)';
                break;
            case 'green':
                document.body.style.backgroundImage = 'url(/img/board.jpg)';
                break;
            case 'yellow':
                document.body.style.backgroundImage = 'url(/img/yellowpaper.jpg)';
                break;
        }
    }
}

function bringFont() {
    let fonts = document.querySelectorAll('.font');

    for (let i = 0; i < fonts.length; i++) {
        let currentFont = fonts[i].textContent;

        console.log(currentFont);

        switch(currentFont) {
            case 'myeongjo':
                document.body.style.fontFamily = 'Nanum Myeongjo';
                break;
            case 'gothic':
                document.body.style.fontFamily = 'Nanum Gothic';
                break;
            case 'notosans':
                document.body.style.fontFamily = 'Noto Sans';
                break;
        }
    }
}

bringPaper();
bringFont();