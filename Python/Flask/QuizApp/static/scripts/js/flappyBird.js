document.addEventListener('DOMContentLoaded', () => {
    const bird = document.querySelector('.bird')
    const container = document.querySelector('.game-container')
    const ground = document.querySelector('.ground')
    const reload = document.createElement('button')
    
    let birdLeft = 220
    let birdBottom = 100
    let gameSpeed = 20
    let gravity = 2
    let newObstacleTime = 3000
    let isGameOver = false
    let gap = 420
    let score = 0
    
    function startGame() {
        birdBottom -= gravity
        bird.style.bottom = birdBottom + 'px'
        bird.style.left = birdLeft + 'px'
        if (birdBottom <= 0) {
            gameOver()
        }
    }

    reload.addEventListener("click", () => window.location.reload())
    reload.innerText = "Replay?"

    let timerId = setInterval(startGame,gameSpeed)

    function control(e) {
        if (e.keyCode === 32) {
            jump()
        }
    }

    function jump() {
        birdBottom += 50
        if (birdBottom >= 500) {
            birdBottom = 500
        }
        bird.style.bottom = birdBottom + 'px'
    }

    document.addEventListener('keydown', control)

    function generateObstacle() {
        let obstacleLeft = 500
        let randomHeight = Math.random() * 60
        let obstacleBottom = randomHeight

        const obstacle = document.createElement('div')
        const topObstacle = document.createElement('div')
        const imgBot = document.createElement('img')
        const imgTop = document.createElement('img')

        if (!isGameOver) {
            score++
            obstacle.classList.add('pipe')
            topObstacle.classList.add('topPipe')
            
            imgBot.src = "/static/images/jsgames/pipe.png"
            imgTop.src = "/static/images/jsgames/pipeTop.png"

            imgBot.classList.add('pipe')
            imgTop.classList.add('topPipe')

            obstacle.appendChild(imgBot)
            topObstacle.appendChild(imgTop)
        }
        container.appendChild(obstacle)
        container.appendChild(topObstacle)

        obstacle.style.left = obstacleLeft + 'px'
        topObstacle.style.left = obstacleLeft + 'px'
        obstacle.style.bottom = obstacleBottom + 'px'
        topObstacle.style.bottom = obstacleBottom + gap + 'px'

        function moveObstacle() {
            obstacleLeft -= 2
            obstacle.style.left = obstacleLeft + 'px'
            topObstacle.style.left = obstacleLeft + 'px'

            if (obstacleLeft === -60) {
                clearInterval(timerId)
                topObstacle.removeChild(imgTop)
                obstacle.removeChild(imgBot)
                container.removeChild(topObstacle)
                container.removeChild(obstacle)
            }

            if (obstacleLeft > 200 && obstacleLeft < 280 && (birdBottom < obstacleBottom + 153 || birdBottom > obstacleBottom + gap - 200)) {
                gameOver()
                clearInterval(timerId)
            }
        }

        let timerId = setInterval(moveObstacle, gameSpeed)
        if (!isGameOver) setTimeout(generateObstacle, newObstacleTime)

    }
    generateObstacle()

    function gameOver() {
        clearInterval(timerId)
        isGameOver = true
        document.removeEventListener('keydown', control)
        container.innerHTML = score - 1
        container.appendChild(reload)
    }
})