document.addEventListener('DOMContentLoaded', () => {
  var currentTab = 0
  var tabs = document.getElementsByClassName("tab")
  var nextBtn = document.getElementById("nextBtn")
  var prevBtn = document.getElementById("prevBtn")
  var subBtn = document.getElementById("subBtn")
  var radios = document.querySelectorAll('input[type="radio"]')
  showTab(currentTab)

  function showTab(n) {
    tabs[n].style.display = "block"

    if (n == 0) {
      prevBtn.style.display = "none"
    } else {
      prevBtn.style.display = "inline"
    }

    if (n == (tabs.length - 1)) {
      nextBtn.style.display = "none"
      subBtn.style.display = "inline"
    } else {
      nextBtn.style.display = "inline"
      subBtn.style.display = "none"
    }
    fixStepIndicator(n)
  }

  function nextPrev(n) {
    tabs[currentTab].style.display = "none"
    currentTab = currentTab + n
    if (currentTab >= tabs.length) {
      document.getElementById("regForm").submit();
      return false
    }
    showTab(currentTab)
  }

  function fixStepIndicator(n) {
    var i, x = document.getElementsByClassName("step")
    for (i = 0, l = x.length; i < l; i++) {
      x[i].className = x[i].className.replace(" active", "")
    }
    x[n].className += " active"
  }

  nextBtn.addEventListener("click", () => nextPrev(1))
  prevBtn.addEventListener("click", () => nextPrev(-1))

})