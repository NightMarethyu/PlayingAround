document.addEventListener("DOMContentLoaded", () => {

  // Get canvas to render
  var canvas = document.getElementById("myCanvas");
  // This will store the 2D rendering context
  var ctx = canvas.getContext("2d");

  // variables for the player
  var score = 0;
  var lives = 3;

  // use variables instead of magic numbers for the ball drawing
  var ballX = canvas.width/2;
  var ballY = canvas.height-30;

  // these variables will change the location of the ball
  var dx = 2;
  var dy = -2;

  // Add some variables defining our ball
  var ballRadius = 10;
  var ballRed = 0;
  var ballGreen = 149;
  var ballBlue = 221;
  var ballOpac = 1;
  //var ballColor = "rgba(" + ballRed + ", " + ballGreen + ", " + ballBlue + ", " + ballOpac + ")";

  // Variables for color change
  var blueChange = 1;
  var greenChange = 1;
  var redChange = 1;

  // Variables for the paddle
  var paddleHeight = 10;
  var paddleWidth = 75;
  var paddleX = (canvas.width - paddleWidth) / 2;
  var paddleSpeed = 7;

  // Variables for the keyboard controls
  var rightPressed = false;
  var leftPressed = false;

  // Begin drawing the game
  draw();

  // These are the variables for the brick field
  var brickRowCount = 3;
  var brickColumnCount = 5;
  var brickWidth = 75;
  var brickHeight = 20;
  var brickPadding = 10;
  var brickOffsetTop = 30;
  var brickOffsetLeft = 30;

  // Here is the array for the bricks
  var bricks = [];
  for (var c=0; c < brickColumnCount; c++) {
    bricks[c] = [];
    for (var r=0; r < brickRowCount; r++) {
      bricks[c][r] = { x: 0, y: 0, status: 1 };
    }
  }

  // Function to draw the bricks
  function drawBricks() {
    for(var c=0; c < brickColumnCount; c++) {
      for(var r=0; r < brickRowCount; r++) {
        if (bricks[c][r].status == 1) {
          var brickX = (c * (brickWidth + brickPadding)) + brickOffsetLeft;
          var brickY = (r * (brickHeight + brickPadding)) + brickOffsetTop;
          bricks[c][r].x = brickX;
          bricks[c][r].y = brickY;
          ctx.beginPath();
          ctx.rect(brickX, brickY, brickWidth, brickHeight);
          ctx.fillStyle = "#0095DD";
          ctx.fill();
          ctx.closePath();
        }
      }
    }
  }

  // Draw ball function for reusability and code cleanliness
  function drawBall() {
    ctx.beginPath();
    ctx.arc(ballX, ballY, ballRadius, 0, Math.PI*2);
    ctx.fillStyle = "rgba(" + ballRed + ", " + ballGreen + ", " + ballBlue + ", " + ballOpac + ")";
    ctx.fill();
    ctx.closePath();
  }

  // Now we need to add a function to draw the paddle
  function drawPaddle() {
    ctx.beginPath();
    ctx.rect(paddleX, canvas.height-paddleHeight, paddleWidth, paddleHeight);
    ctx.fillStyle = "rgba(" + ballRed + ", " + ballGreen + ", " + ballBlue + ", " + ballOpac + ")";
    ctx.fill();
    ctx.closePath();
  }

  // Here we will do the collision detection
  function collisionDetection() {
    for(var c=0; c < brickColumnCount; c++) {
      for(var r=0; r < brickRowCount; r++) {
        var b = bricks[c][r];
        if (b.status == 1) {
          if (ballX > b.x && ballX < b.x + brickWidth && ballY > b.y && ballY < b.y + brickHeight) {
            dy = -dy;
            b.status = 0;
            score++;
            if (score == brickColumnCount * brickRowCount) {
              alert("YOU WIN, CONGRATULATIONS!");
              document.location.reload();
            }
          }
        }
      }
    }
  }

  // We will draw the score and lives here
  function drawScore() {
    ctx.font = "16px Arial";
    ctx.fillStyle = "#0095DD";
    ctx.fillText("Score: " + score, 8, 20);
  }

  function drawLives() {
    ctx.font = "16px Arial";
    ctx.fillStyle = "#0095DD";
    ctx.fillText("Lives: " + lives, canvas.width-65, 20);
  }

  // This will draw the ball and move it around the screen
  // setInterval will constantly refresh the drawing
  function draw() {
    // This first line clears the canvas for a clean frame
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawBricks();
    drawBall();
    drawPaddle();
    drawScore();
    drawLives();
    collisionDetection();

    // Add wall collision detection
    if (ballX + dx > canvas.width - ballRadius || ballX + dx < ballRadius) {
      dx = -dx;
    }

    // This if block will bounce the ball of the top of the canvas
    // but it will end the game if the ball gets to the bottom
    if (ballY + dy < ballRadius) {
      dy = -dy;
    } else if (ballY + dy > canvas.height - ballRadius) {
      if (ballX > paddleX && ballX < paddleX + paddleWidth) {
        dy = -dy;
      } else {
        lives--;
        if(!lives) {
          alert("GAME OVER");
          document.location.reload();
        } else {
          ballX = canvas.width/2;
          ballY = canvas.height-30;
          dx = 2;
          dy = -2;
          paddleX = (canvas.width-paddleWidth)/2;
        }
      }
    }

    ballX += dx;
    ballY += dy;

    // Add logic for moving the paddle
    if(rightPressed) {
      paddleX += paddleSpeed;
      if (paddleX + paddleWidth > canvas.width) {
        paddleX = canvas.width - paddleWidth;
      }
    }
    else if (leftPressed) {
      paddleX -= paddleSpeed;
      if (paddleX < 0) {
        paddleX = 0;
      }
    }

    // I want to make the color of the paddle and ball change
    if (ballBlue > 255 || ballBlue < 0) {
      blueChange = -blueChange;
    }
    if (ballRed > 255 || ballRed < 0) {
      redChange = -redChange;
    }
    if (ballGreen > 255 || ballGreen < 0) {
      greenChange = -greenChange;
    }

    ballBlue += blueChange;
    ballGreen += greenChange;
    ballRed += redChange;

    requestAnimationFrame(draw);
  }
  // Here we add the event listeners for the keyup and keydown
  document.addEventListener("keydown", keyDownHandler, false);
  document.addEventListener("keyup", keyUpHandler, false);

  // Adding mouse controls
  document.addEventListener("mousemove", mouseMoveHandler, false);

  // Here we will add the functions being called by the keyboard event listeners
  function keyDownHandler(e) {
    if(e.key == "Right" || e.key == "ArrowRight" || e.key == "d") {
      rightPressed = true;
    } 
    else if (e.key == "Left" || e.key == "ArrowLeft" || e.key == "a") {
      leftPressed = true;
    }
  }

  function keyUpHandler(e) {
    if(e.key == "Right" || e.key == "ArrowRight" || e.key == "d") {
      rightPressed = false;
    }
    else if (e.key == "Left" || e.key == "ArrowLeft" || e.key == "a") {
      leftPressed = false;
    }
  }

  function mouseMoveHandler(e) {
    var relativeX = e.clientX - canvas.offsetLeft;
    if (relativeX > 0 && relativeX < canvas.width) {
      paddleX = relativeX - paddleWidth / 2;
    }
  }
})