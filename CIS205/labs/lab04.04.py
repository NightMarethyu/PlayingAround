from sys import argv

def main():
    # Check if the number of arguments given is correct return error if not
    if(len(argv) == 3):
        n = int(argv[1])
        r = int(argv[2])

        print("Iteritive: ", end='')
        print(perm2(n, r))
        print("Recursive: ", end='')
        print(perm1(n, r))
    else:
        print("USAGE: lab04.04.py <number of objects> <number of choices>")

# this function will calculate the permutations using a recursive method
# it calls the method twice and divides the results
def perm1(n, r):
    return int(int(fact(n)) / int(fact(n-r)))

# This method will calculate the permutations by multipling the number
# given until it reaches a certain stopping point it works on the
# principle that 10!/8! is equal to 10*9 because 10! is 10*9*8! and one can
# eliminate terms (in this example 8!)
def perm2(n, r):
    fact = 1
    for i in range(r):
        fact *= (n-i)
    return fact

# This is the recursive factorial function
def fact(n):
    if n == 0:
        return 1
    else:
        return n * fact(n-1)

if __name__ == "__main__":
    main()