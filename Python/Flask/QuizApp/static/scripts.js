document.addEventListener('DOMContentLoaded', () => {
  var currentTab = 0
  showTab(currentTab)

  function showTab(n) {
    var x = document.getElementsByClassName("tab")
    x[n].style.display = "block"

    if (n == 0) {
      document.getElementById("prevBtn").style.display = "none"
    } else {
      document.getElementById("prevBtn").style.display = "inline"
    }

    if (n == (x.length - 1)) {
      document.getElementById("nextBtn").style.display = "none"
      document.getElementById("subBtn").style.display = "inline"
    } else {
      document.getElementById("nextBtn").style.display = "inline"
      document.getElementById("subBtn").style.display = "none"
    }
  }

  function nextPrev(n) {
    var x = document.getElementsByClassName("tab")

    x[currentTab].style.display = "none"

    currentTab = currentTab + n

    if (currentTab >= x.length) {
      document.getElementById("regForm").submit();
      return false
    }

    showTab(currentTab)
  }

  document.getElementById('nextBtn').addEventListener("click", () => nextPrev(1))
  document.getElementById('prevBtn').addEventListener("click", () => nextPrev(-1))

})