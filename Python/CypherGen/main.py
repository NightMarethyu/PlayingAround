import random, string

possibleChars = [
        "♓", "♒", "♑", "♐", "♏", "♎", "♍", "♌", "♋", "♊", "♉", "♈",
        "ϡ", "〴", "≬", "⋰", "⋱", "⋭", "⍣", "⍢", "⍠", "⍝", "⌻", "⌺", "⌹", "⌸",
        "⍎", "﹡", "◧", "◨", "◩", "◪", "◫", "⫷", "◐", "◑", "◒", "◓", "◔", "◕",
        "θ", "〄", "⊠", "❥", "ღ", "❦", "➳", "⚘", "❂", "⊗", "◙", "◚", "◛", "▰", "▱",
        "⍌", "⍍", "⍨", "⍥", "☭", "☯", "☥", "☸", "☪", "☦", "⇋", "⇍", "⇎", "⇏", "⇕",
        "⇪", "⌦", "⇱", "⟿", "⇴", "≭", "≠", "ܗ", "ø", "°", "♯", "♮", "♭", "♦", "♢", "♥",
        "♡", "♣", "♧", "♠", "♤", "☊", "❅", "۞", "꙰", "࿏", "✾", "¢", "$", "€", "£", "¥", "₮",
        "฿"
    ]

def main():
    alpha = dict.fromkeys(string.ascii_lowercase, "")
    
    nonDest = []
    
    for i in possibleChars:
        nonDest.append(i)
    
    vals = []
    
    for i in range(len(alpha)):
        vals.append(random.randint(1, 5))

    cypher = genDict(alpha, nonDest, vals)
    #cypherNew = newGenDict(al, possibleChars, vals)
    print(possibleChars)
    print(nonDest)
    
    f = open("text.txt", "a", encoding='utf-8')
    #print(cypher, file=f)
    #print(cypherNew, file=f)

"""def newGenDict(alpha, chars, count):
    myDict = {}
    j = 0
    for i in count:
        char = ""
        for x in range(i):
            ran = random.choice(chars)
            char += ran
            chars.remove(ran)
        
        myDict[char] = alpha[j]
        j += 1
    
    return myDict
    """

def genDict(a, c, vals):
    i = 0
    for k in a:
        char = ""
        for ii in range(vals[i]):
            ran = random.choice(c)
            char += ran
            c.remove(ran)
        a[k] = char
        i += 1
    
    return a

if __name__ == "__main__":
    main()