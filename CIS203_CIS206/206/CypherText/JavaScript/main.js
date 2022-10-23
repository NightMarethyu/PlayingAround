document.addEventListener('DOMContentLoaded', () => {
  const ALPHABET = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];
  const DISPLAY_TEXT = document.querySelector('#output');

  const runMessage = () => {
    var message = document.forms["myForm"]["message"].value;
    var version = document.forms["myForm"]["version"].value;
    var key = document.forms["myForm"]["key"].value;

    var useKey = (version == "part1" || version == "part2");    
    var isEncode = (version == "part1");

    if (useKey) {
      DISPLAY_TEXT.innerHTML = encodeDecode(message, key, isEncode);
    } else {
      var lines = "";
      for (var i = 0; i < ALPHABET.length; i++) {
        lines += encodeDecode(message, i, false);
        lines += "\n";
      }
      DISPLAY_TEXT.innerHTML = lines;
    }
  }

  function encodeDecode(mes, key, isEncode) {
    var output = "";
    var el = mes.split(" ");
    el.forEach((value, foo, bar) => {
      Array.from(value).forEach((curLet, foo2, bar2) => {
        var index = ALPHABET.indexOf(curLet);
        console.log(index)
        var newChar = (isEncode) ? ALPHABET[ALPHABET.length % (index + key)] : ALPHABET[ALPHABET.length % (index - key)];
        output += newChar;
      })
      output += " ";
    })
    return output;
  }
  
  document.getElementById("myButton").addEventListener("click", runMessage);
})