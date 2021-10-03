class Mine {
  constructor() {
    this.primed = false;
    this.nearbyMines = 0;
  }
  setMine() {
    this.primed = !this.primed;
  }
  setNearCount() {
    this.nearbyMines++;
  }
  isSet() {
    return this.primed;
  }
  getNearCount() {
    return this.nearbyMines;
  }
  onClick = () => {
    if (this.primed) {
      alert("Mine Clicked");
    } else {
      console.log("nothing there");
    }
  }
}

document.addEventListener('DOMContentLoaded', () => {

  const fullSize = 10;
  const mineCount = 10;
  const grid = document.querySelector('.grid');

  let mines = new Array(fullSize);

  for (i = 0; i < mines.length; i++) {
    mines[i] = new Array(fullSize);
  }

  for (i = 0; i < fullSize; i++) {
    for (j = 0; j < fullSize; j++) {
      mines[i][j] = new Mine();
    }
  }

  // place the mines
  for (var i = 0; i < mineCount; i++) {
    let x = Math.trunc(Math.random() * mineCount);
    let y = Math.trunc(Math.random() * mineCount);

    if (!mines[x][y].primed) {
      mines[x][y].setMine();
    } else {
      i--;
    }
    
  }

  // Calculate the numbers in surrounding squares
  for (var i = 0; i < fullSize; i++) {
    for (var j = 0; j < fullSize; j++) {
      if (mines[i][j].isSet()) {
        if (i > 0 && j > 0 && i != fullSize - 1 && j != fullSize - 1) {
          mines[i-1][j-1].setNearCount();
          mines[i-1][j].setNearCount();
          mines[i-1][j+1].setNearCount();
          mines[i][j-1].setNearCount();
          mines[i][j+1].setNearCount();
          mines[i+1][j-1].setNearCount();
          mines[i+1][j].setNearCount();
          mines[i+1][j+1].setNearCount();
        } else if(i === 0 && j > 0 && j != fullSize - 1) {
          mines[i][j-1].setNearCount();
          mines[i][j+1].setNearCount();
          mines[i+1][j-1].setNearCount();
          mines[i+1][j].setNearCount();
          mines[i+1][j+1].setNearCount();
        } else if (j === 0 && i > 0 && i != fullSize - 1) {
          mines[i+1][j].setNearCount();
          mines[i+1][j+1].setNearCount();
          mines[i][j+1].setNearCount();
          mines[i-1][j].setNearCount();
          mines[i-1][j+1].setNearCount();
        } else if (i === fullSize - 1 && j > 0 && j != fullSize - 1) {
          mines[i-1][j-1].setNearCount();
          mines[i-1][j].setNearCount();
          mines[i-1][j+1].setNearCount();
          mines[i][j-1].setNearCount();
          mines[i][j+1].setNearCount();
        } else if (j === fullSize - 1 && i > 0 && i != fullSize - 1) {
          mines[i-1][j-1].setNearCount();
          mines[i-1][j].setNearCount();
          mines[i][j-1].setNearCount();
          mines[i+1][j-1].setNearCount();
          mines[i+1][j].setNearCount();
        } else if (i === 0 && j === 0) {
          mines[i+1][j].setNearCount();
          mines[i][j+1].setNearCount();
          mines[i+1][j+1].setNearCount();
        } else if (i === fullSize - 1 && j === 0) {
          mines[i-1][j].setNearCount();
          mines[i][j+1].setNearCount();
          mines[i-1][j+1].setNearCount();
        } else if (i === 0 && j === fullSize - 1) {
          mines[i+1][j].setNearCount();
          mines[i][j-1].setNearCount();
          mines[i+1][j-1].setNearCount();
        } else if (i === fullSize - 1 && j === fullSize - 1) {
          mines[i-1][j].setNearCount();
          mines[i-1][j-1].setNearCount();
          mines[i][j-1].setNearCount();
        }
      }
    }
  }
  
  // display the grid of squares
  for (var i = 0; i < fullSize; i++) {
    let row = document.createElement('div');
    row.classList.add('row');
    grid.appendChild(row);
    for (var j = 0; j < fullSize; j++) {
      let square = document.createElement('button');
      square.classList.add('square');
      square.setAttribute("type", "button");
      if (mines[i][j].isSet()) {
        square.classList.add('mine');
      } else if (mines[i][j].getNearCount() > 0) {
        square.innerHTML = mines[i][j].getNearCount();
      }
      row.appendChild(square);
    }
  }

})