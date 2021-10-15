for i in range(10):
    # Ask user for type of math, add, sub, div, mul
    print("Select math type using add, sub, div, or mul")
    mathType = input("Enter type: ")

    # Get numbers from user
    x = int(input("Enter First Number: "))
    y = int(input("Enter Second Number: "))

    # Do the math that the user wants
    if mathType == "add" or mathType == "a" or mathType == "A" or mathType == "addition" or mathType == "Addition" or mathType == "+":
        print(x + y)
    elif mathType == "sub":
        print(x - y)
    elif mathType == "div":
        print(x / y)
    elif mathType == "mul":
        print(x * y)