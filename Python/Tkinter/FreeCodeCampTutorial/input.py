from tkinter import *

# This program will be about adding input boxes to the GUI
root = Tk()

# unfortunately they didn't call it an input widget in Tkinter
# instead it's an entry widget
e = Entry(root)
e.pack()
e.insert(0, "Enter your name: ")
# To retrieve the data from the entry we need to run the get method
# remember you can't use e = Entry(root).pack() and then later run e.get()


def myClick():
    name = e.get()
    myLabel = Label(root, text="Plus Ultra " + name).pack()
    
myButton = Button(root, text="Go Beyond!", command=myClick).pack()

root.mainloop()