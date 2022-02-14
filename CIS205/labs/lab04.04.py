from sys import argv

def main():
    n = int(argv[1])
    r = int(argv[2])

    print("Iteritive: ", end='')
    print(perm2(n, r))
    print("Recursive: ", end='')
    print(perm1(n, r))

def perm1(n, r):
    return int(int(fact(n)) / int(fact(n-r)))

def perm2(n, r):
    fact = 1
    for i in range(r):
        fact *= (n-i)
    return fact

def fact(n):
    if n == 0:
        return 1
    else:
        return n * fact(n-1)

if __name__ == "__main__":
    main()