from sys import argv, exit

def main():
    if (len(argv) > 1):
        if (argv[1].isdigit()):
            rows = int(argv[1])
            drawPyramid(rows)
        elif (argv[1].startswith('-') and argv[1][1:].isdigit()):
            rows = int(argv[1][1:])
            drawReversePyramid(rows)
            exit(1)
        else:
            print("ERROR: Command-line parameter must be a digit")
            exit(1)
    else:
        print("ERROR: Please supply command-line parameter")
        exit(1)

def drawRow(sp, st):
    for _ in range(sp):
        print(' ', end='')
    for _ in range(st):
        print('*', end='')
    print()

def drawPyramid(rows):
    for i in range(rows):
        spaces = rows - (i + 1)
        stars = i + i + 1
        drawRow(spaces, stars)

def drawReversePyramid(rows):
    for i in reversed(range(rows)):
        spaces = rows - (i + 1)
        stars = i + i + 1
        drawRow(spaces, stars)

if __name__ == "__main__":
    main()