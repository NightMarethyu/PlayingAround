import Ball from "./Ball"

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