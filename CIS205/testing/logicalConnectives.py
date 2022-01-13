a = [True, False]
b = [True, False]
t = "\t"

print("A\tB\tA XOR B")
for i in a:
    for j in b:
        result = i ^ j
        print(str(i) + t + str(j) + t + str(result))

print()

print("A\tB\tA NAND B")
for i in a:
    for j in b:
        result = not (i and j)
        print(str(i) + t + str(j) + t + str(result))

print()

print("A\tB\tA NOR B")
for i in a:
    for j in b:
        result = not (i or j)
        print(str(i) + t + str(j) + t + str(result))