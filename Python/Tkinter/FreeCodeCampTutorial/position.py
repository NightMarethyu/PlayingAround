# This is going to be about the Grid system in Tkinter
# We will start with the basic code from the hello.py file

from tkinter import *

root = Tk()

myLabel1 = Label(root, text="No more evil doing for you, little akuma.")
myLabel2 = Label(root, text="Bye Bye little butterfly.")

# Each widget is it's own grid square
# They are all relative, so making the numbers bigger won't make it bigger
# if there isn't anything in column 1 and we set the second object to column 2
# it won't look any different
myLabel1.grid(row=0, column=0)
myLabel2.grid(row=1, column=1)

# Everything in Tkinter is a two step process, first we create the thing
# then we put it on the screen

root.mainloop()