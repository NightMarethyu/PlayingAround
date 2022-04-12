from hashlib import new


class Sudoku:
    def __init__(self, puzzle):
        self.puzzle = puzzle
        self.rows = []
        self.columns = [[]] * 9
        self.boxes = []
        self.parseRowsColumns()
        # for r in self.rows:
        #     print(r)
        # for c in self.columns:
        #     print(c)
        
    def parseRowsColumns(self):
        for i in self.puzzle:
            self.rows.append(i)
            for count, val in enumerate(i):
                self.columns[count].append(val)