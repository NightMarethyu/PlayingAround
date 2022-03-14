from sys import argv

def main():
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

def isfloat(x):
    try:
        float(x)
        return True
    except:
        return False

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
