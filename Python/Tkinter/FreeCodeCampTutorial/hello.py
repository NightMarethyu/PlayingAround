# Tkinter is included with Python, so there is no pip install that needs to happen
# Start by importing the package into the file

from tkinter import *

# This is the first thing that needs to be created for Tkinter to have a 
# window to reference
root = Tk()

# We need something to display so here is a label to display 
myLabel = Label(root, text="Hello there\nGeneral Kenobi")

# The super basic way of displaying things in a tkinter gui is using pack()
myLabel.pack()

# We now need to have an event loop, this will allow the stuff to be displayed
# it also has events like mouse movement, button clicks, keyboard input. This is
# consistent with all GUI applications.
root.mainloop()