document.addEventListener('DOMContentLoaded', () => {
    const banner = document.getElementById("wel-banner")
    const greetings = ["Welcome", "ようこそ", "Maligayong Pagdating", "Bienvenue", "добро пожаловать"]
    var current = 0
    
    setInterval(() => {
        banner.innerHTML = greetings[current]
        current++
        if (current >= greetings.length) {
            current = 0
        }
    }, 5000)
})