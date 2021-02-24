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
    #print(possibleChars)
    #print(nonDest)
    
    print(changeText(cypher))
    

def changeText(cypher):
    userText = input("Enter your text: ")
    encode = ""
    for c in userText:
        if c == " ":
            continue
        encode += cypher[c.lower()]
    return encode

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