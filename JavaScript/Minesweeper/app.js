document.addEventListener('DOMContentLoaded', () => {

  const fullSize = 10;
  const mineCount = 10;
  const grid = document.querySelector('.grid');

  let mines = new Array(fullSize);

  for (i = 0; i < mines.length; i++) {
    mines[i] = new Array(fullSize);
  }

  // create the grid of mines
  for (var i = 0; i < mines.length; i++) {
    let x = Math.trunc(Math.random() * mineCount);
    let y = Math.trunc(Math.random() * mineCount);

    mines[x][y] = true;
  }
  
  // create a grid of squares
  for (var i = 0; i < fullSize; i++) {
    let row = document.createElement('div');
    row.classList.add('row');
    grid.appendChild(row);
    for (var j = 0; j < fullSize; j++) {
      let square = document.createElement('div');
      square.classList.add('square');
      if (mines[i][j]) {
        square.classList.add('mine');
      }
      row.appendChild(square);
    }
  }

})