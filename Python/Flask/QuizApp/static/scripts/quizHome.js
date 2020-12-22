document.addEventListener('DOMContentLoaded', () => {
  const cards = document.getElementsByClassName('quiz-link-title')
  let width = cards[0].clientWidth.toString() + 'px'
  for (var i = 0; i < cards.length; i++) {
    cards[i].style.height = width
  }
})