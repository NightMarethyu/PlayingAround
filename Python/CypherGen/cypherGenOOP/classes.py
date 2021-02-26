from tkinter import *

from helpers import genKey, runEncrypt

class cypherInterface:
    def __init__(self, root):
        self.root = root
        self.curKey = {}
        self.icon = PhotoImage(file="bill-cipher.png")
        self.userText = Text(root, width=45, height=13, wrap=WORD)
        self.userText.grid(row=0, column=0, rowspan=9, padx=10, pady=10)
        self.maxChara = Entry(root, width="3")
        self.maxChara.grid(row=1, column=1)
        self.genKeyBut = Button(root, text="Generate Key", padx=5, pady=5, command=self.runKeyGen).grid(row=2, column=1)
        self.keyText = Text(root, width=45, height=13, wrap=WORD)
        self.keyText.grid(row=0, column=2, rowspan=9, padx=10, pady=10)
        self.runEncryptBut = Button(root, text="Encrypt", padx=5, pady=5, command=self.runEncrypt).grid(row=8, column=1)
        self.encodedMessageText = Text(root, width=120, height=10, wrap=WORD)
        self.encodedMessageText.grid(row=9, column=0, columnspan=3, padx=10, pady=10)
        
        root.title("CypherGen")
        root.iconphoto(False, self.icon)
        Label(root, text="Max Characters", font="bold", pady=5).grid(row=0, column=1)
        Label(root, text="Add Salt", font="bold").grid(row=3, column=1)
        Radiobutton(root, text="None", variable=self.isSalted, value="none").grid(row=4, column=1)
        Radiobutton(root, text="Before", variable=self.isSalted, value="before", tristatevalue="x").grid(row=5, column=1)
        Radiobutton(root, text="After", variable=self.isSalted, value="after", tristatevalue="x").grid(row=6, column=1)
        Radiobutton(root, text="Both", variable=self.isSalted, value="both", tristatevalue="x").grid(row=7, column=1)
        
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
        
        self.encodedMessageText.insert(1.0, runEncrypt(self.isSalted.get(), mes, self.curKey))