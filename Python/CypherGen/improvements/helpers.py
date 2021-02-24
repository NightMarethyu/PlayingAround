import random, string

import settings

settings.init()

def genDict(maxChars=1):
    alpha = dict.fromkeys(string.ascii_lowercase, "")
    nonDest = []
    vals = []
    for i in settings.possibleChars:
        nonDest.append(i)
    if maxChars > 1:
        for i in range(len(alpha)):
            vals.append(random.randint(1, maxChars))
    
    loopIter = 0
    for let in alpha:
        if len(vals) > 0:
            char = ""
            for i in range(vals[loopIter]):
                ran = random.choice(nonDest)
                char += ran
                nonDest.remove(ran)
            alpha[let] = char
            loopIter += 1
        else:
            ran = random.choice(nonDest)
            alpha[let] = ran
            nonDest.remove(ran)
            
    #print(alpha)
    return alpha