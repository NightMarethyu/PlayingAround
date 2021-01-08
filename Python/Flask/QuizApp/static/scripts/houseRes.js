document.addEventListener('DOMContentLoaded', () => {
  const houseName = document.getElementById("quizTitle").innerHTML
  const mainDiv = document.getElementsByTagName("body")[0]
  const crestImg = document.getElementById("crestImg")
  var colorBack = ""
  var colorFront = ""
  var crest = document.createElement("img")

  crest.src = '../../static/images/quizzes/' + houseName + 'Crest.png'
  crest.alt = houseName + ' House Crest'
  crestImg.appendChild(crest)
  
  switch(houseName) {
    case "Gryffindor":
      colorBack = "DCAF3A"
      colorFront = "10160F"
      break
    case "Hufflepuff":
      colorBack = "c9972c"
      colorFront = "13191b"
      break
    case "Ravenclaw":
      colorBack = "b9b7c6"
      colorFront = "121d3e"
      break
    case "Slytherin":
      colorBack = "7e7f83"
      colorFront = "15302a"
      break
    default:
      colorBack = "ffffff"
      colorFront = "000000"
      break
  }

  mainDiv.style.backgroundColor = "#" + colorBack
  mainDiv.style.color = "#" + colorFront

})