from tkinter import *

from classes import cypherInterface

# I wanted the Tkinter root available to other functions that I'm
# planning on writing. I think I'll need it available when I 
# start adding other encryptions
root = Tk()

def main():
    # This adds the image to the top corner of the window
    icon = PhotoImage(file="bill-cipher.png")
    root.title("CypherGen")
    root.iconphoto(False, icon)
    
    # Right now I only have the one interface, but I'll
    # probably want to change this in soon
    userInterface = cypherInterface(root)
    
    # This starts the GUI
    root.mainloop()
    
if __name__ == "__main__":
    main()