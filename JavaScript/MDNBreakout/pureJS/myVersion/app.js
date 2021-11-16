document.addEventListener("DOMContentLoaded", () => {

  const canvas = document.getElementById("myCanvas");
  const ctx = canvas.getContext("2d");

  // this will be for the ball
  var ballSize = 10;
  var ballSpeed = 2;
  var ballX = canvas.width / 2;
  var ballY = canvas.height - 30;
  var ball = new Ball(ballSize, ballSpeed, ballX, ballY);

  // add a new paddle
  var paddleSpeedChange = 7;
  var paddleHeight = 10;
  var paddleWidth = 75;
  var paddleX = (canvas.width - paddleWidth) / 2;
  var paddleColor = "#0095DD";
  var rightPressed = false;
  var leftPressed = false;
  var paddle = new Paddle(paddleHeight, paddleWidth, paddleX, paddleColor);

  // Begin drawing the game
  draw();

  function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ball.draw(ctx);
    paddle.draw(ctx, canvas.height);

    ball.checkEdge(canvas);

    // Move the ball
    ball.move();

    // move the paddle
    if (rightPressed) {
      paddle.speed = paddleSpeedChange;
    } else if (leftPressed) {
      paddle.speed = -paddleSpeedChange;
    } else {
      paddle.speed = 0;
    }

    paddle.move(canvas);

    // Draw the next frame
    requestAnimationFrame(draw);
  }

  // this event listener will check if the user is currently pressing a key
  // it will then move the paddle by changing the appropriate key pressed var
  document.addEventListener("keydown", (e) => {
    if (e.key == "Right" || e.key == "ArrowRight" || e.key == "d") {
      rightPressed = true;
    } else if (e.key == "Left" || e.key == "ArrowLeft" || e.key == "a") {
      leftPressed = true;
    }
  }, false);

  // this listener is similar to the one above but will stop movement when
  // the key is released
  document.addEventListener("keyup", (e) => {
    if (e.key == "Right" || e.key == "ArrowRight" || e.key == "d") {
      rightPressed = false;
    } else if (e.key == "Left" || e.key == "ArrowLeft" || e.key == "a") {
      leftPressed = false;
    }
  }, false)

})

class Ball {
  constructor(rad, speed, x, y) {
    this.radius = rad;
    this.speedX = speed;
    this.speedY = -speed;
    this.x = x;
    this.y = y;
    this.color = "#0095DD"
  }

  draw(ctx) {
    ctx.beginPath();
    ctx.arc(this.x, this.y, this.radius, 0, Math.PI*2);
    ctx.fillStyle = this.color;
    ctx.fill();
    ctx.closePath();
  }

  move() {
    this.x += this.speedX;
    this.y += this.speedY;
  }

  checkEdge(canvas) {
    if (this.speedX + this.x > canvas.width || this.x + this.speedX < this.radius) {
      this.speedX = -this.speedX;
    }

    if (this.y + this.speedY < this.radius || this.y + this.speedY > canvas.height) {
      this.speedY = -this.speedY;
    }
  }
}

class Paddle {
  constructor(height, width, x, color) {
    this.height = height;
    this.width = width;
    this.x = x;
    this.speed = 0;
    this.color = color;
  }

  draw(ctx, h) {
    ctx.beginPath();
    ctx.rect(this.x, h - this.height, this.width, this.height);
    ctx.fillStyle = this.color;
    ctx.fill();
    ctx.closePath();
  }

  move(canvas) {
    if (this.speed) {
      this.x += this.speed;
      
      if (this.x + this.width > canvas.width) {
        this.x = canvas.width - this.width;
      } else if (this.x < 0) {
        this.x = 0;
      }
    }
  }
}