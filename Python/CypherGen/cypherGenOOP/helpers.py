import random, string

# This variable is the list of characters that is used by the current encryption
# I'll probably need to move this into a global variables file in the future
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

# This is to encrypt the numbers. They are the Chinese numbers and they just get assigned
# one to one. The way the current system works it is nearly impossible to guess these
nums = ["一", "二", "三", "四", "五", "六", "七", "八", "九", "〇"]

# This function generates the key for the encryption
def genKey(maxChars=1):
    # alpha here is the dictionary that acts as the key
    alpha = dict.fromkeys(string.ascii_lowercase, "")
    # this is the dictionary key for the numbers
    number = dict.fromkeys(string.digits, "")
    
    # I wanted the encryption to never reuse the same characters
    # and the way I do that later will destroy my variable
    # to fix that I copy the variable to a new instance
    # non Destructive Alpha
    nonDestA = []
    # non Destructive Numbers
    nonDestN = []

    for i in possibleChars:
        nonDestA.append(i)
    for n in nums:
        nonDestN.append(n)
    
    # The numbers don't currently have a more complex encryption
    # than one to one so I don't have any logic that applies
    for c in number:
        rand = random.choice(nonDestN)
        number[c] = rand
        nonDestN.remove(rand)

    # each letter needs a new representation
    for a in alpha:
        
        # If the characters are supposed to have more than one
        # symbol to represent them do this
        if maxChars > 1:
            # I start with an empty string to apply it to the 
            # dict value
            char = ""
            for i in range(random.randint(1, maxChars)):
                # The built-in random.choice is really helpful here
                ran = random.choice(nonDestA)
                char += ran
                nonDestA.remove(ran)
            alpha[a] = char
        # This is for a one to one alphabet encryption
        else:
            ran = random.choice(nonDestA)
            alpha[a] = ran
            nonDestA.remove(ran)
            
    return alpha, number

# I wanted this to be a separate function because I can see myself
# using this in a bunch of different places
def genSalt():
    letters = string.ascii_lowercase + string.digits
    return (''.join(random.choice(letters) for i in range(random.randint(12, 20))))

# The actual encryption is really simple
# the hardest part was to get the salt stuff to work
# and that was mostly just an issue with tkinter
def runEncrypt(salt, mes, key):
    encode = ""
    
    # I'm always disappointed when I remember that 
    # Python doesn't have a built in Switch statement
    # If I get around to it I'll make one myself
    if salt == "after":
        mes += genSalt()
    elif salt == "before":
        mes = genSalt() + mes
    elif salt == "both":
        mes = genSalt() + mes + genSalt()
    
    # The encryption is really easy, just assign the
    # string in the key to the letter.
    for c in mes:
        if c.isalpha():
            encode += key[0][c.lower()]
        elif c.isdigit():
            encode += key[1][c]
        else:
            continue

    return encode