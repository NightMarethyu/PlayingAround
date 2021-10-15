document.addEventListener('DOMContentLoaded', () => {
  var body = document.getElementsByTagName('body')[0]
  var starCount = Math.floor((Math.random() * 50) + 100)
  var createStars = ""
  var starSizes = ""
  var starPos = ""

  for (var i = 0; i < starCount; i++) {
    let randSize = Math.floor((Math.random() * 5) + 2).toString() + "px"
    let randPos1 = Math.floor(Math.random() * 95).toString() + "% "
    let randPos2 = Math.floor(Math.random() * 95).toString() + "%"
    createStars = createStars + 'radial-gradient(circle, rgba(255, 255, 255, 0.7) 20%, transparent 30%)'
    starSizes = starSizes + randSize + " " + randSize
    starPos = starPos + randPos1 + randPos2
    if (!(i == starCount - 1)) {
      createStars = createStars + ', '
      starSizes = starSizes + ', '
      starPos = starPos + ', '
    }
  }

  body.style.backgroundImage = createStars
  body.style.backgroundSize = starSizes
  body.style.backgroundPosition = starPos
})