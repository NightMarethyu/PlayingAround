const validateForm = () => {
  var x = document.forms["myForm"]["fname"].value;
  if (x == "") {
    alert("Name must be filled out");
    return false;
  } else {
    alert(`Hello, ${x}`)
    return true;
  }
}

document.getElementById("myButton").addEventListener("click", validateForm)