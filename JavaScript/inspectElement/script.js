document.addEventListener('DOMContentLoaded', () => {
  const balance = document.querySelector('.check').innerHTML

  setInterval(function () {
    let change = document.querySelector('.check').innerHTML
    if (change !== balance){
      window.location.reload()
    }
  }, 10000)
})