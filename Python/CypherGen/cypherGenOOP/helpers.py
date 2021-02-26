import random, string

possibleChars = [
    "♓", "♒", "♑", "♐", "♏", "♎", "♍", "♌", "♋", "♊", "♉", "♈",
    "ϡ", "〴", "≬", "⋰", "⋱", "⋭", "⍣", "⍢", "⍠", "⍝", "⌻", "⌺", "⌹", "⌸",
    "⍎", "﹡", "◧", "◨", "◩", "◪", "◫", "⫷", "◐", "◑", "◒", "◓", "◔", "◕",
    "θ", "〄", "⊠", "❥", "ღ", "❦", "➳", "⚘", "❂", "⊗", "◙", "◚", "◛", "▰", "▱",
    "⍌", "⍍", "⍨", "⍥", "☭", "☯", "☥", "☸", "☪", "☦", "⇋", "⇍", "⇎", "⇏", "⇕",
    "⇪", "⌦", "⇱", "⟿", "⇴", "≭", "≠", "ܗ", "ø", "°", "♯", "♮", "♭", "♦", "♢", "♥",
    "♡", "♣", "♧", "♠", "♤", "☊", "❅", "۞", "꙰", "࿏", "✾", "¢", "$", "€", "£", "¥", "₮",
    "฿", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
    "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
]

nums = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "〇"]

def genKey(maxChars=1):
    alpha = dict.fromkeys(string.ascii_lowercase, "")
    nonDest = []
    vals = []
    for i in possibleChars:
        nonDest.append(i)
    if maxChars > 1:
        for i in range(len(alpha)):
            vals.append(random.randint(1, maxChars))
            
    loopIter = 0
    for a in alpha:
        if len(vals) > 0:
            char = ""
            for i in range(vals[loopIter]):
                ran = random.choice(nonDest)
                char += ran
                nonDest.remove(ran)
            alpha[a] = char
            loopIter += 1
        else:
            ran = random.choice(nonDest)
            alpha[a] = ran
            nonDest.remove(ran)
            
    return alpha

def genSalt():
    letters = string.ascii_letters
    return (''.join(random.choice(letters) for i in range(random.randint(12, 20))))

def runEncrypt(salt, mes, key):
    encode = ""
    
    if salt == "after":
        mes += genSalt()
    elif salt == "before":
        mes = genSalt() + mes
    elif salt == "both":
        mes = genSalt() + mes + genSalt()
        
    for c in mes:
        if c.isalpha():
            encode += key[c.lower()]
        else:
            continue

    return encode