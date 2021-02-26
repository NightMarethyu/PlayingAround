from tkinter import Tk

from classes import cypherInterface

def main():
    root = Tk()
    userInterface = cypherInterface(root)
    root.mainloop()
    
if __name__ == "__main__":
    main()