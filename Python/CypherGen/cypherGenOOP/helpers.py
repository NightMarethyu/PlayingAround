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
    number = dict.fromkeys(string.digits, "")
    nonDestA = []
    nonDestN = []
    vals = []
    for i in possibleChars:
        nonDestA.append(i)
    for n in nums:
        nonDestN.append(n)
    for c in number:
        rand = random.choice(nonDestN)
        number[c] = rand
        nonDestN.remove(rand)

    if maxChars > 1:
        for i in range(len(alpha)):
            vals.append(random.randint(1, maxChars))
            
    loopIter = 0
    for a in alpha:
        if len(vals) > 0:
            char = ""
            for i in range(vals[loopIter]):
                ran = random.choice(nonDestA)
                char += ran
                nonDestA.remove(ran)
            alpha[a] = char
            loopIter += 1
        else:
            ran = random.choice(nonDestA)
            alpha[a] = ran
            nonDestA.remove(ran)
            
    return alpha, number

def genSalt():
    letters = string.ascii_lowercase + string.digits
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
            encode += key[0][c.lower()]
        elif c.isdigit():
            encode += key[1][c]
        else:
            continue

    return encode