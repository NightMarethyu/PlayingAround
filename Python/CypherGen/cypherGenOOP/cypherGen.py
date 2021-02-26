from tkinter import *

from classes import cypherInterface

root = Tk()

def main():
    icon = PhotoImage(file="bill-cipher.png")
    root.title("CypherGen")
    root.iconphoto(False, icon)
    
    userInterface = cypherInterface(root)
    
    root.mainloop()
    
if __name__ == "__main__":
    main()