document.addEventListener('DOMContentLoaded', () => {
  function disableCheckboxes(boxList) {
    var checkboxes = boxList

    for (var i = 0, x = checkboxes.length; i < x; i++) {
      checkboxes[i].disabled = true
    }

    return true
  }

  function checkLimitedCheckboxes(maxLength) {
    var boxes = document.getElementsByClassName("activities")
    var blen = boxes.length
    var checked = []
    var unchecked = []

    for (var i = 0; i < blen; i++) {
      if (boxes[i].checked) {
        checked.push(boxes[i])
      }
    }

    if (checked.length >= maxLength) {
      for (var i = 0; i < blen; i++) {
        if (!boxes[i].checked) {
          unchecked.push(boxes[i])
        }
      }
      disableCheckboxes(unchecked)
    } else {
      for (var i = 0; i < blen; i++) {
        boxes[i].disabled = false
      }
    }

    return true
  }

  const validateForm = () => {
    var comp = parseInt(document.querySelector('input[name="companion"]:checked').value)
    var dest = parseInt(document.querySelector('input[name="destination"]:checked').value)
    var packClass = document.getElementsByClassName("packingBoxes")
    var travel = parseInt(document.querySelector('input[name="travelling"]:checked').value)
    var actClass = document.getElementsByClassName("activities")
    var finalNight = parseInt(document.querySelector('input[name="finalnight"]:checked').value)

    const getValues = (checks) => {
      let current = 0
      for(var i=0, x=checks.length; i < x; i++) {
        if(checks[i].checked) {
          current = current + parseInt(checks[i].value)
        }
      }
      return current
    }

    var pack = getValues(packClass)
    var act = getValues(actClass)

    var score = comp + dest + travel + finalNight + pack + act

    switch (true) {
      case (score >= 20):
        alert("Holiday Hero: Dwayne Johnson just called to see if he could come with you next time")
        break;
      case (score >= 0 && score < 20):
        alert("Suitcase Slugger: Nice Work! Your pictures got thousands of likes on the 'Gram")
        break;
      case (score < 0 && score > -20):
        alert("Summer Bummer: Was that the best you could do? Next time, just stay at home")
        break;
      case (score <= -20):
        alert("Astro-Naught: You wrecked havoc across the universe, enjoy space jail")
        break;
      default:
        alert("Something went wrong")
        break;
    }
  }

  document.getElementById("myButton").addEventListener("click", validateForm)
  let activities = document.getElementsByClassName("activities")
  let actLim = 2

  for (var i = 0, x = activities.length; i < x; i++) {
    activities[i].addEventListener("click", () => checkLimitedCheckboxes(actLim))
  }
})