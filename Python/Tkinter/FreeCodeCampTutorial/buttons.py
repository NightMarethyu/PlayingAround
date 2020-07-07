from tkinter import *

root = Tk()

# to add functionality to the button we need to give it a function to execute
def myClick():
    myLabel = Label(root, text="The future is in the past.\nOnwards Aoshima!")
    myLabel.pack()

# Buttons can have a state such as state=DISABLED
# we can also make the button larger using Padding (think CSS) (padx=50, pady=50)
# Since we defined the function already we can add it's function to our button
# using command=nameOfFunction. Colors can be changed using fg for text and bg for
# the background color
myButton = Button(root, text="Mabel, I need your advice", command=myClick)
myButton.pack()

root.mainloop()