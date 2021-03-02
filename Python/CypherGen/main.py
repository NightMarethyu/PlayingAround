from tkinter import filedialog
from tkinter import *

def askSave(rt):
    rt.filename =  filedialog.asksaveasfilename(initialdir = "/",title = "Select file",filetypes = (("jpeg files","*.jpg"),("all files","*.*")))
    print (rt.filename)

root = Tk()
Button(root, text="Save As", command=lambda: askSave(root)).pack()
root.mainloop()