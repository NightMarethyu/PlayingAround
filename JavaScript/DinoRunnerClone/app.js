document.addEventListener('DOMContentLoaded', () => {
  const canvas = document.getElementById('myCanvas');

  var ctx = canvas.getContext("2d");

  // I'll use this later
  var score = 0;

  // some constants for the player's jumping
  const ground = canvas.height - 100;
  const jumpHeight = canvas.height - 225;

  // These variables define the player character
  var playerHeight = 50;
  var playerWidth = 35;
  var playerX = 80;
  var playerY = ground;
  var jumpSpeed = 13;
  var fallSpeed = 14;
  var isJumping = false;
  var isFalling = false;
  var canJump = true;

  // This function will draw the game
  function draw() {
    // first I need to make sure the canvas is empty
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // draw the player and eventually the enemies
    drawPlayer();

    // Logic to allow the player to jump
    if (isJumping && !isFalling) {
      playerY -= jumpSpeed;
      if (playerY <= jumpHeight) {
        canJump = false;
        isJumping = false;
        isFalling = true;
      }
    } else if (isFalling) {
      playerY += fallSpeed;
      if (playerY >= ground) {
        canJump = true;
        isFalling = false;
        playerY = ground;
      }
    }

    requestAnimationFrame(draw);
  }

  // Here is the function that actually draws the player
  function drawPlayer() {
    ctx.beginPath();
    ctx.rect(playerX, playerY, playerWidth, playerHeight);
    ctx.fillStyle = "#00FF00";
    ctx.fill();
    ctx.closePath();
  }


  // event listeners to add controls
  document.addEventListener("keydown", (e) => {
    if (e.key == ' ' && canJump) {
      isJumping = true;
      isFalling = false;
    }
  })

  document.addEventListener("keyup", (e) => {
    if (e.key == ' ') {
      isJumping = false;
      isFalling = true;
    }
  })

  // after everything has loaded draw the first frame
  draw();
})