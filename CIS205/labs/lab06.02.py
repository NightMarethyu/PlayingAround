from sys import argv

# This fuction loads the file given in argv[1] and passes it to
# the evaluation function. This will also print the values that
# are calculated from the evalString function.
def main():
    first = '6 6 * 2 7 * - 2 /'
    print('Result of "' + first + '": ', end='')
    print(evalString(first), end="\n\n")
    if(len(argv) == 2):
        try:
            with open(argv[1]) as f:
                for l in f:
                    print("Input: ", end='')
                    print(l, end='')
                    print("Result: ", end='')
                    print(evalString(l))
                    print()
        except:
            print("Could not find input file.")
            exit(-1)
    else:
        print("Must include filename as commandline parameter")
        exit(-1)

# This function will evaluate the string as a Reverse Polish Notation
# mathmatical equation. It will split the sting on each space " "
# and will return the computed value as a float
def evalString(rpn):
    vals = rpn.strip().split()
    stack = []

    for i in vals:
        if isfloat(i):
            stack.append(float(i))
        else:
            val1 = stack.pop()
            val2 = stack.pop()
            eqate = evaluateVals(val2, val1, i)
            stack.append(eqate)
    return stack[0]

# Due to python's built-in string methods not having a great
# float checking tool, I built this one using a try except
# block, it will try to convert the provided variable to a float
# if it succeeds True will be returned
def isfloat(x):
    try:
        float(x)
        return True
    except:
        return False

# This will evaluate the given values using the provided
# string which should be one of "+-/*" otherwise it will
# return None, since the provided equation isn't there.
def evaluateVals(x, y, f):
    if (f == "+"):
        return x + y
    elif (f == "*"):
        return x * y
    elif (f == "/"):
        return x / y
    elif (f == "-"):
        return x - y
    else:
        return None

if (__name__ == "__main__"):
    main()
