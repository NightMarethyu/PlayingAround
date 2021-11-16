export default class Ball {
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