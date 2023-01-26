def printAllKLength(set, k):
    n = len(set)
    printAllKLengthRec(set, "", n, k)


def printAllKLengthRec(set, prefix, n, k):
    if k == 0:
        if len(prefix) <= 6:
            print(prefix)
            return
        else:
            return

    for j in range(n):
        newPrefix = prefix + set[j]
        printAllKLengthRec(set, newPrefix, n, k-1)


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print("All Values of strings less than 6:")
    for i in [1, 2, 3, 4, 5, 6]:
        printAllKLength(['a', 'ab', 'ba'], i)

