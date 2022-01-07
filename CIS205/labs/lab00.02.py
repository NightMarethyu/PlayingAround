import sys

def main():
    if (len(sys.argv) > 1):
        try:
            with open(sys.argv[1]) as f:
                print(countEight(f))
        except:
            print("ERROR: File not found")
            sys.exit(1)
    else:
        print("ERROR: must include command-line parameter")

def countEight(file):
    count = 0
    for line in file:
        clean = line.strip()
        chars = clean.split(" ")
        for c in chars:
            if (c == "8"):
                count += 1
    return count

if (__name__ == "__main__"):
    main()