function openTab(e, name) {
    var tabcontent = document.getElementsByClassName("tab-data")
    var tablinks = document.getElementsByClassName("tab-title")
    for (var i = 0, x = tabcontent.length; i < x; i++) {
        tabcontent[i].style.display = "none"
    }
    for (var i = 0, x = tablinks.length; i < x; i++) {
        tablinks[i].classList.remove("active-tab")
    }
    document.getElementById(name).style.display = "block"
    e.currentTarget.classList.add("active-tab")

    if (name == "Recommendations") {
        let subs = document.getElementsByClassName("sub-tab-data")
        let sublinks = document.getElementsByClassName("sub-tab-title")
        for (var i = 0, x = subs.length; i < x; i++) {
            subs[i].style.display = "none"
        }
        for (var i = 0, x = sublinks.length; i < x; i++) {
            sublinks[i].classList.remove("active-tab")
        }
        subs[0].style.display = "block"
        sublinks[0].classList.add("active-tab")
    }
}

function openSubTab(e, name) {
    var tabcontent = document.getElementsByClassName("sub-tab-data")
    var tablinks = document.getElementsByClassName("sub-tab-title")
    for (var i = 0, x = tabcontent.length; i < x; i++) {
        tabcontent[i].style.display = "none"
    }
    for (var i = 0, x = tablinks.length; i < x; i++) {
        tablinks[i].classList.remove("active-tab")
    }
    document.getElementById(name).style.display = "block"
    e.currentTarget.classList.add("active-tab")
}

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('Professional').style.display = "block"
    document.getElementsByClassName('tab-title')[0].classList.add("active-tab")
})