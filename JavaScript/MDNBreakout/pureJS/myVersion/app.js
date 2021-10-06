document.addEventListener("DOMContentLoaded", () => {

  const canvas = document.getElementById("myCanvas");
  const ctx = canvas.getContext("2d");

  var ballSize = 10;
  var ballSpeed = 2;
  var ballX = canvas.width / 2;
  var ballY = canvas.height - 30;
  var ball = new Ball(ballSize, ballSpeed, ballX, ballY);

  ball.draw(ctx);

})

class Ball {
  constructor(rad, speed, x, y) {
    this.radius = rad;
    this.speed = speed;
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
}