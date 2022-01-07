from sys import argv
import sys

def main():
    if (len(argv) > 1):
        if (argv[1].isdigit()):
            rows = int(argv[1])
            if (rows < 0):
                print("ERROR: Number must be non-negative")
                sys.exit(1)
            drawPyramid(rows)
        else:
            print("ERROR: Command-line parameter must be a digit")
            sys.exit(1)
    else:
        print("ERROR: Please supply command-line parameter")
        sys.exit(1)

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

if __name__ == "__main__":
    main()