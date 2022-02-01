from sys import argv

def main():
    if (len(argv) <= 1):
        print(fibi(10))
    else:
        given = int(argv[1]) - 1
        print(fibi(given))

def fibi(x):
    val = 1
    prev = 0
    for i in range(x):
        temp = val + prev
        #print(temp)
        prev = val
        val = temp
    return val

if __name__ == "__main__":
    main()