from tkinter import *

from helpers import genKey, runEncrypt

class cypherInterface:
    def __init__(self, root):
        self.root = root
        
        # I needed to declare a variable for the radio buttons to work
        self.salting = "none"
        
        # They key is a list of dictionaries, 0 is the alphabetical
        # key while 1 is the numeric
        self.curKey = []
        
        # Here are start adding the tkinter items
        # They tkinter layout is 3 columns and a bunch of rows
        # I decided all the items need to be declared and then
        # put into the grid. This allows me to reference them and make
        # changes if I need to. I found that if I put them in the
        # grid when they are declared it caused problems with the
        # .get() method.
        self.userText = Text(root, width=45, height=13, wrap=WORD)
        self.userText.grid(row=1, column=0, rowspan=8, padx=10, pady=10)
        self.maxChara = Entry(root, width="3")
        self.maxChara.grid(row=1, column=1)
        self.genKeyBut = Button(root, text="Generate Key", padx=5, pady=5, command=self.runKeyGen)
        self.genKeyBut.grid(row=2, column=1)
        self.keyText = Text(root, width=45, height=13, wrap=WORD)
        self.keyText.grid(row=1, column=2, rowspan=8, padx=10, pady=10)
        self.runEncryptBut = Button(root, text="Encrypt", padx=5, pady=5, command=self.runEncrypt)
        self.runEncryptBut.grid(row=8, column=1)
        self.encodedMessageText = Text(root, width=120, height=10, wrap=WORD)
        self.encodedMessageText.grid(row=10, column=0, columnspan=3, padx=10, pady=10)
        
        self.mesLab = Label(root, text="Your Message", font="bold", pady=5)
        self.mesLab.grid(row=0, column=0)
        self.keyLab = Label(root, text="Secret Key", font="bold", pady=5)
        self.keyLab.grid(row=0, column=2)
        self.codeLab = Label(root, text="Encoded Message", font="bold", pady=5)
        self.codeLab.grid(row=9, column=1)
        self.maxCLab = Label(root, text="Max Characters", font="bold", pady=5)
        self.maxCLab.grid(row=0, column=1)
        self.saltLabel = Label(root, text="Add Salt", font="bold", cursor="question_arrow")
        self.saltLabel.grid(row=3, column=1)
        self.saltLabel.bind("<Button-1>", self.saltHelp)
        self.rdNone = Radiobutton(root, text="None", variable=self.salting, value="none", command=lambda: self.addSalt("none"))
        self.rdNone.grid(row=4, column=1)
        self.rdBefore = Radiobutton(root, text="Before", variable=self.salting, value="before", command=lambda: self.addSalt("before"), tristatevalue="x")
        self.rdBefore.grid(row=5, column=1)
        self.rdAfter = Radiobutton(root, text="After", variable=self.salting, value="after", command=lambda: self.addSalt("after"), tristatevalue="x")
        self.rdAfter.grid(row=6, column=1)
        self.rdBoth = Radiobutton(root, text="Both", variable=self.salting, value="both", command=lambda: self.addSalt("both"), tristatevalue="x")
        self.rdBoth.grid(row=7, column=1)
        
    # This method will generate the key for the encryption
    # it gets info from the tkinter input and then passes
    # it to the helpers function genKey()
    def runKeyGen(self):
        # This gets the value a user put into the form
        userEntry = self.maxChara.get()
        
        # If they are regenerating the key I need the
        # Keyfield clear so I can either put warnings there
        # or put the new key
        self.keyText.delete(1.0, END)
        
        if userEntry:
            # If the user doesn't put a number into the
            # form I don't want the app to crash.
            try:
                maxC = int(userEntry)
            except:
                # I'm using the keyText field to display warnings to the
                # user. I figure that is a pretty logical place to put these warnings
                self.keyText.insert(1.0, "Max Characters must be a number between 1 and 6")
                self.curKey = []
                return
            # If the number is outside this range, it's likely to cause
            # a problem with the key, because we could run out of
            # available symbols.
            if maxC > 6 or maxC <= 0:
                self.keyText.insert(1.0, "Max Characters must be a number between 1 and 6")
                # added this because I realized if the user trys to run the
                # encryption after previously creating a key the key will not be there
                # This would make it hard to send a key with the encryption
                self.curKey = []
                return
            else:
                # I send the user input from above to the genKey() function
                # that function handles the actual key generation.
                # If I want to in the future I can edit that function as well as this one
                # to send a list of possible characters, that will make the keys
                # more variable, assuming I make more types of encryptions
                self.curKey = genKey(maxC)
                self.keyText.insert(1.0, self.curKey)
                return
        else:
            self.curKey = genKey()
            self.keyText.insert(1.0, self.curKey)
            return
    
    # This will send the user's inputed message, the key
    # and the type of salt to the runEncrypt() helper function
    def runEncrypt(self):
        # if the user clicked on the "Add Salt" label or had a
        # previously generated message we need to clear it out
        self.encodedMessageText.delete(1.0, END)
        mes = self.userText.get(1.0, END)
        
        # If the user hasn't created a key already, a key
        # needs to be created
        if not self.curKey:
            self.runKeyGen()
        
        self.encodedMessageText.insert(1.0, runEncrypt(self.salting, mes, self.curKey))
        
    # I needed a function to update the salting variable
    def addSalt(self, val):
        self.salting = val
    
    # I've had to explain what the "Add Salt" means so I decided
    # that I would add some help by putting it in the
    # encoded message text box
    def saltHelp(self, event):
        self.encodedMessageText.delete(1.0, END)
        self.encodedMessageText.insert(1.0, "Add Salt: Salting is a common security practice, usually it means to add a string of random characters before a password. This makes common passwords, like 123456 or password, slightly more secure. The usage here is slightly modified but the same principle. This will automatically add a salt (random letters and numbers) to the beginning or ending (or both) of your message. It will add between 12 and 20 characters. This will further obfuscate the message, making it more clear. The default selection is \"None\"")