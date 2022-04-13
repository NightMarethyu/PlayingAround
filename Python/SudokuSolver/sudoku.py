class Sudoku:
    def __init__(self, puzzle):
        self.puzzle = puzzle
        self.rows = []
        self.columns = []
        self.boxes = []
        self.parseRows()
        self.parseColumns()
        self.parseBoxes()
        # print("## Rows ##")
        # for r in self.rows:
        #     print(r)
        # print("## Columns ##")
        # for c in self.columns:
        #     print(c)
        print('## Boxes ##')
        for b in self.boxes:
            print(b)
        
    def parseRows(self):
        for i in self.puzzle:
            self.rows.append(i)
    
    def parseColumns(self):
        temp = []
        for i in range(9):
            for j in range(9):
                temp.append(self.rows[j][i])
            self.columns.append(temp)
            temp = []
    
    def parseBoxes(self):
        box1 = []
        box2 = []
        box3 = []
        box4 = []
        box5 = []
        box6 = []
        box7 = []
        box8 = []
        box9 = []
        for count, row in enumerate(self.rows):
            if (count < 3):
                box1.append(row[:3])
                box2.append(row[3:6])
                box3.append(row[6:])
            elif (count >= 3 and count < 6):
                box4.append(row[:3])
                box5.append(row[3:6])
                box6.append(row[6:])
            else:
                box7.append(row[:3])
                box8.append(row[3:6])
                box9.append(row[6:])
        self.boxes.append(box1)
        self.boxes.append(box2)
        self.boxes.append(box3)
        self.boxes.append(box4)
        self.boxes.append(box5)
        self.boxes.append(box6)
        self.boxes.append(box7)
        self.boxes.append(box8)
        self.boxes.append(box9)
        
class Box:
    def __init__(self):
        # TODO