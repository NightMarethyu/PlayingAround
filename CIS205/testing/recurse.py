from sys import argv

def main():
    if (len(argv) <= 1):
        print(fib(10))
    else:
        var = int(argv[1])
        print(fib(var))

def fib(i):
    if (i == 1 or i == 0):
        return 1
    else:
        return fib(i-2) + fib(i-1)

if __name__ == "__main__":
    main()