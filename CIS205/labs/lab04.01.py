from sys import argv, exit

# Main function reads in a file and sends the rows as a
# list of sets to the function that will do the processing
def main():
    if (len(argv) > 1):
        sets = []
        i = 0
        try:
            with open(argv[1]) as f:
                for line in f:
                    elements = line.strip().split(' ')
                    sets.append(set(elements))
                    i += 1
                setManipulations(sets)
        except:
            print("File not found")
            exit(-1)
    else:
        print("Must include filename as command line paramenter")
        exit(-1)

# this function will perform the requested operations
# on the given sets
def setManipulations(sets):
    setA = sets[0]
    setB = sets[1]
    temp = set([])
    
    # first print setA
    print("A = ", end='')
    print(setA)
    
    # next print setB
    print("B = ", end='')
    print(setB)
    
    # print what is the same in both sets
    print("A intersect B = ", end='')
    print(setA & setB)
    
    # print both sets combined
    print("A union B = ", end='')
    print(setA | setB)
    
    # Remove any elements of A that are in B then print A
    print("A - B = ", end='')
    print(setA - setB)
    
    # remove any elements of B that are in A then print B
    print("B - A = ", end='')
    print(setB - setA)
    
    # Make ordered pairs for all the elements in both sets
    # have the elements in A be in the first position
    print("A x B = ", end='')
    for i in setA:
        for j in setB:
            temp.add("("+i+","+j+")")
    print(temp)
    temp = set([])
    
    # do same as above but with elements of B in first position
    for i in setB:
        for j in setA:
            temp.add("("+i+","+j+")")
    print("B x A = ", end='')
    print(temp)

if (__name__ == "__main__"):
    main()