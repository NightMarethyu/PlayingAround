from tkinter import *

from helpers import genKey, runEncrypt

class cypherInterface:
    def __init__(self, root):
        self.root = root
        self.isSalted = "none"
        self.curKey = {}
        self.userText = Text(root, width=45, height=13, wrap=WORD)
        self.userText.grid(row=1, column=0, rowspan=8, padx=10, pady=10)
        self.maxChara = Entry(root, width="3")
        self.maxChara.grid(row=1, column=1)
        self.genKeyBut = Button(root, text="Generate Key", padx=5, pady=5, command=self.runKeyGen).grid(row=2, column=1)
        self.keyText = Text(root, width=45, height=13, wrap=WORD)
        self.keyText.grid(row=1, column=2, rowspan=8, padx=10, pady=10)
        self.runEncryptBut = Button(root, text="Encrypt", padx=5, pady=5, command=self.runEncrypt).grid(row=8, column=1)
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
        self.rdNone = Radiobutton(root, text="None", variable=self.isSalted, value="none", command=lambda: self.addSalt("none"))
        self.rdNone.grid(row=4, column=1)
        self.rdBefore = Radiobutton(root, text="Before", variable=self.isSalted, value="before", command=lambda: self.addSalt("before"), tristatevalue="x")
        self.rdBefore.grid(row=5, column=1)
        self.rdAfter = Radiobutton(root, text="After", variable=self.isSalted, value="after", command=lambda: self.addSalt("after"), tristatevalue="x")
        self.rdAfter.grid(row=6, column=1)
        self.rdBoth = Radiobutton(root, text="Both", variable=self.isSalted, value="both", command=lambda: self.addSalt("both"), tristatevalue="x")
        self.rdBoth.grid(row=7, column=1)
        
    def runKeyGen(self):
        temp = self.maxChara.get()
        self.keyText.delete(1.0, END)
        
        if temp:
            try:
                maxC = int(temp)
            except:
                self.keyText.insert(1.0, "Max Characters must be a number between 1 and 6")
                return False
            if maxC > 6:
                self.keyText.insert(1.0, "Max Characters must be a number between 1 and 6")
                return False
            else:
                self.curKey = genKey(maxC)
                self.keyText.insert(1.0, self.curKey)
                return True
        else:
            self.curKey = genKey()
            self.keyText.insert(1.0, self.curKey)
            return True
    
    def runEncrypt(self):
        self.encodedMessageText.delete(1.0, END)
        mes = self.userText.get(1.0, END)
        
        if not self.curKey:
            self.runKeyGen()
        
        self.encodedMessageText.insert(1.0, runEncrypt(self.isSalted, mes, self.curKey))
        
    def addSalt(self, val):
        self.isSalted = val
    
    def saltHelp(self, event):
        self.encodedMessageText.delete(1.0, END)
        self.encodedMessageText.insert(1.0, "Add Salt: Salting is a common security practice, usually it means to add a string of random characters before a password. This makes common passwords, like 123456 or password, slightly more secure. The usage here is slightly modified but the same principle. This will automatically add a salt (random letters and numbers) to the beginning or ending (or both) of your message. It will add between 12 and 20 characters. This will further obfuscate the message, making it more clear. The default selection is \"None\"")