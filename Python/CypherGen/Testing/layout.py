from tkinter import *

isSalted = "none"

root = Tk()

root.title("CypherGen")

icon = PhotoImage(file="bill-cipher.png")
root.iconphoto(False, icon)

userText = Text(root, width=50, height=10, wrap=WORD)
userText.grid(row=0, column=0, rowspan=7, padx=10, pady=10)

genKeyBut = Button(root, text="Generate Key", padx=5, pady=5)
genKeyBut.grid(row=0, column=1)

keyText = Text(root, width=50, height=10, wrap=WORD)
keyText.grid(row=0, column=2, rowspan=7, padx=10, pady=10)

Label(root, text="Add Salt").grid(row=1, column=1)

Radiobutton(root, text="None", variable=isSalted, value="none").grid(row=2, column=1)
Radiobutton(root, text="Before", variable=isSalted, value="before", tristatevalue="x").grid(row=3, column=1)
Radiobutton(root, text="After", variable=isSalted, value="after", tristatevalue="x").grid(row=4, column=1)
Radiobutton(root, text="Both", variable=isSalted, value="both", tristatevalue="x").grid(row=5, column=1)

runEncryptBut = Button(root, text="Encrypt", padx=5, pady=5)
runEncryptBut.grid(row=6, column=1)

encodedMessageText = Text(root, width=120, height=10, wrap=WORD)
encodedMessageText.grid(row=7, column=0, columnspan=3, padx=10, pady=10)

root.mainloop()

