function paperChange() {
    let paper = document.getElementById("paper");
    let currentPaper = paper.value;
    
    switch(currentPaper) {
        case "plain":
            document.body.style.backgroundImage = "url('/img/plain.jpg')";
            break;
        case "cardboard":
            document.body.style.backgroundImage = "url('/img/cardboard.jpg')";
            break;
        case "squared":
            document.body.style.backgroundImage = "url('/img/squared.jpg')";
            break;
    }
}