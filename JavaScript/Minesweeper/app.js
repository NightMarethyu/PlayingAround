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
      mines[i][j] = { 'mined': false, 'nearCount': 0 };
    }
  }

  // place the mines
  for (var i = 0; i < mineCount; i++) {
    let x = Math.trunc(Math.random() * mineCount);
    let y = Math.trunc(Math.random() * mineCount);

    mines[x][y]['mined'] = true;
  }

  // Calculate the numbers in surrounding squares
  for (var i = 0; i < fullSize; i++) {
    for (var j = 0; j < fullSize; i++) {
      if (mines[i][j]['mined']) {
        if (i > 0 && j > 0 && i != fullSize - 1 && j != fullSize - 1) {
          mines[i-1][j-1]['nearCount'] += 1;
          mines[i-1][j]['nearCount'] += 1;
          mines[i-1][j+1]['nearCount'] += 1;
          mines[i][j-1]['nearCount'] += 1;
          mines[i][j+1]['nearCount'] += 1;
          mines[i+1][j-1]['nearCount'] += 1;
          mines[i+1][j]['nearCount'] += 1;
          mines[i+1][j+1]['nearCount'] += 1;
        } else if(i === 0 && j > 0 && j != fullSize - 1) {
          mines[i][j-1]['nearCount'] += 1;
          mines[i][j+1]['nearCount'] += 1;
          mines[i+1][j-1]['nearCount'] += 1;
          mines[i+1][j]['nearCount'] += 1;
          mines[i+1][j+1]['nearCount'] += 1;
        } else if (j === 0 && i > 0 && i != fullSize - 1) {
          mines[i+1][j]['nearCount'] += 1;
          mines[i+1][j+1]['nearCount'] += 1;
          mines[i][j+1]['nearCount'] += 1;
          mines[i-1][j]['nearCount'] += 1;
          mines[i-1][j+1]['nearCount'] += 1;
        } else if (i === fullSize - 1 && j > 0 && j != fullSize - 1) {
          mines[i-1][j-1]['nearCount'] += 1;
          mines[i-1][j]['nearCount'] += 1;
          mines[i-1][j+1]['nearCount'] += 1;
          mines[i][j-1]['nearCount'] += 1;
          mines[i][j+1]['nearCount'] += 1;
        } else if (j === fullSize - 1 && i > 0 && i != fullSize - 1) {
          mines[i-1][j-1]['nearCount'] += 1;
          mines[i-1][j]['nearCount'] += 1;
          mines[i][j-1]['nearCount'] += 1;
          mines[i+1][j-1]['nearCount'] += 1;
          mines[i+1][j]['nearCount'] += 1;
        } else if (i === 0 && j === 0) {
          mines[i+1][j]['nearCount'] += 1;
          mines[i][j+1]['nearCount'] += 1;
          mines[i+1][j+1]['nearCount'] += 1;
        } else if (i === fullSize - 1 && j === 0) {
          mines[i-1][j]['nearCount'] += 1;
          mines[i][j+1]['nearCount'] += 1;
          mines[i-1][j+1]['nearCount'] += 1;
        } else if (i === 0 && j === fullSize - 1) {
          mines[i+1][j]['nearCount'] += 1;
          mines[i][j-1]['nearCount'] += 1;
          mines[i+1][j-1]['nearCount'] += 1;
        } else if (i === fullSize - 1 && j === fullSize - 1) {
          mines[i-1][j]['nearCount'] += 1;
          mines[i-1][j-1]['nearCount'] += 1;
          mines[i][j-1]['nearCount'] += 1;
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
      let square = document.createElement('div');
      square.classList.add('square');
      if (mines[i][j]['mined']) {
        square.classList.add('mine');
      } else {
        square.innerHTML = mines[i][j]['nearCount'];
      }
      row.appendChild(square);
    }
  }

})