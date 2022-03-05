from sys import argv

def main():
    # first check if the command line parameters are correct
    if(len(argv) == 2):
        originSet = []
        pairs = []
        # Load the file and read each line into the variables
        try:
            with open(argv[1]) as f:
                count = 0
                for l in f:
                    line = l.strip()
                    if (count == 0):
                        originSet = line.split()
                    else:
                        x = line.split()
                        pairs.append(x)
                    count += 1
        except:
            print("Could not find input file.")
            exit(-1)
        
        # Print the set and ordered pairs in a nice format
        print("Set: ", end='')
        setPrint(originSet)
        print("Relation: ", end='')
        printOrd(pairs)
        
        # here we call the functions to check if the sets are reflexive and symmetric (one at at time)
        print("Reflexive: ", end='')
        print(reflexTest(originSet, pairs))
        print("Symmetric: ", end='')
        print(symTest(pairs))
    else:
        print("Must include filename as command line parameter")
        exit(-1)

# This function checks if the set is reflexive
# it compares the values in the input set (inSet)
# with the pairs (p) to see if each value in inSet
# is associated with itself in p
def reflexTest(inSet, p):
    count = 0
    for i in inSet:
        if [i, i] in p:
            count += 1
    if (count == len(inSet)):
        return "Yes"
    else:
        return "No"

# This function checks if the set is symmetric
# it compares the values in the given ordered pairs (p)
# to see if both as (a,b) and (b,a) are in the list of pairs
def symTest(p):
    count = 0
    for c in p:
        x = c[0]
        y = c[1]
        if [y, x] in p:
            count += 1
    if (count == len(p)):
        return "Yes"
    else:
        return "No"

# This function prints the set in a nice set format
def setPrint(s):
    print("{", end='')
    c = len(s)
    for x in range(c):
        if(x == (c-1)):
            print(s[x], end='')
        else:
            print(s[x] + ', ', end='')
    print("}")

# this function prints the ordered pairs in a nice format
def printOrd(s):
    print("{", end='')
    c = len(s)
    for x in range(c):
        print("(" + s[x][0] + "," + s[x][1] + ")", end='')
        if(x == (c-1)):
            print("}")
        else:
            print(", ",end='')

if __name__ == "__main__":
    main()