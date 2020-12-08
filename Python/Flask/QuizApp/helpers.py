def vacation(ans):
    print(ans)

def testQuiz(ans, res):
    count = {
        "r": 0,
        "g": 0,
        "h": 0,
        "s": 0
    }
    
    for x in ans:
        if x[0] == "-":
            count[x[1]] = count[x[1]] - len(x)
        else:
            for c in x:
                count[c] = count[c] + 1
    
    return res[str(max(count, key=count.get))]


def rescalc(quiz, ans, results):
    if quiz == "vacation":
        vacation(ans)
    elif quiz == "testQuiz":
        return testQuiz(ans, results)
    
    return True