document.addEventListener("DOMContentLoaded", () => {
    const banner = document.getElementById("wel-banner");
    const greetings = [
        "Welcome",
        "ようこそ",
        "Maligayong Pagdating",
        "Bienvenue",
        "добро пожаловать",
    ];
    var current = 0;
    var timing = 500;
    var curTxt = '';
    var backspace = false;

    function typing() {
        var i = current % greetings.length;
        var full = greetings[i];

        if (backspace) {
            curTxt = full.substring(0, curTxt.length - 1);
        } else {
            curTxt = full.substring(0, curTxt.length + 1);
        }

        banner.innerHTML = curTxt;

        if (!backspace && curTxt === full) {
            backspace = true;
        } else if (backspace && curTxt === '') {
            backspace = false;
            current++;
        }
    }

    setInterval(typing, timing);
});