from sys import argv, exit

vals = []

# The main function will read in a file, put each line of the file
# into the vals variable as integers, and then call the sort function
# If a command line parameter is not given or the file is not found
# this function will print the error and exit
def main():
    if (len(argv) > 1):
        try:
            with open(argv[1]) as f:
                for line in f:
                    vals.append(int(line.strip()))
                print(vals)
                sort205(0, (len(vals) - 1))
                for i in vals:
                    print(i)
        except:
            print("File not found")
            exit(-1)
    else:
        print("Must include filename as command line parameter")
        exit(-1)

# This function recursively calls itself to sort the array in segments
def sort205(p, r):
    if (p < r):
        q = divide(p, r)
        sort205(p, q-1)
        sort205(q+1, r)

# This function will sort the array one value at a time
# it is an implementation of the quick sort algorythm
# it has a counter that will increment across the array
# and a "pivot" that will eventually be placed in the
# appropriate position relative to the other elements
# in the array. The sorting will be complete when all
# elements have been placed.
def divide(p, r):
    x = vals[r]
    i = p-1
    
    for j in range(p, r):
        if (vals[j] <= x):
            i += 1
            vals[i], vals[j] = vals[j], vals[i]
    vals[i+1], vals[r] = vals[r], vals[i+1]
    return(i+1)

if __name__ == "__main__":
    main()