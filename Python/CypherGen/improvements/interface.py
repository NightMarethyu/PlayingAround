from tkinter import *
from tkinter import ttk
import random, string

import settings
from helpers import genDict

settings.init()

root = Tk()

root.title("Cipher Generator")

userInput = Text(root, width=50, height=5, wrap=WORD)
userInput.pack()

maxChars = ttk.Entry(root, width=2)
maxChars.pack()

generateKey = ttk.Button(root, text="Generate Key", command=lambda: checkKeyLength()).pack()

keyField = Text(root, width=50, height=5, wrap=WORD)
keyField.pack()

def checkKeyLength():
    keyField.delete(1.0, END)
    charLen = maxChars.get()
    if charLen == '':
        keyField.insert(1.0, genDict())
    elif charLen.isnumeric():
        keyField.insert(1.0, genDict(int(charLen)))
    else:
        keyField.insert(1.0, "Must be a number between 1 and 6")

root.mainloop()