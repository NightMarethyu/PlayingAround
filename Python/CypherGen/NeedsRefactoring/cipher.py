from tkinter import *

import settings
from helpers import genKey

settings.init()

root = Tk()

def main():
    isSalted = "none"

    root.title("CypherGen")

    icon = PhotoImage(file="bill-cipher.png")
    root.iconphoto(False, icon)

    userText = Text(root, width=45, height=13, wrap=WORD)
    userText.grid(row=0, column=0, rowspan=9, padx=10, pady=10)

    Label(root, text="Max Characters", font="bold", pady=5).grid(row=0, column=1)

    maxChara = Entry(root, width="3").grid(row=1, column=1)

    genKeyBut = Button(root, text="Generate Key", padx=5, pady=5, command=lambda: runKeyGen())
    genKeyBut.grid(row=2, column=1)

    keyText = Text(root, width=45, height=13, wrap=WORD)
    keyText.grid(row=0, column=2, rowspan=9, padx=10, pady=10)

    Label(root, text="Add Salt", font="bold").grid(row=3, column=1)

    Radiobutton(root, text="None", variable=isSalted, value="none").grid(row=4, column=1)
    Radiobutton(root, text="Before", variable=isSalted, value="before", tristatevalue="x").grid(row=5, column=1)
    Radiobutton(root, text="After", variable=isSalted, value="after", tristatevalue="x").grid(row=6, column=1)
    Radiobutton(root, text="Both", variable=isSalted, value="both", tristatevalue="x").grid(row=7, column=1)

    runEncryptBut = Button(root, text="Encrypt", padx=5, pady=5)
    runEncryptBut.grid(row=8, column=1)

    encodedMessageText = Text(root, width=120, height=10, wrap=WORD)
    encodedMessageText.grid(row=9, column=0, columnspan=3, padx=10, pady=10)

    root.mainloop()
    
def runKeyGen():
    maxC = root.maxChara.get()
    if maxC.isalpha():
        root.keyText.insert(1.0, "Must be a number between 1 and 6")
    elif maxC == '':
        root.keyField.insert(1.0, genKey())

if __name__ == "__main__":
    main()