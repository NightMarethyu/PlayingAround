import winshell

r = list(winshell.recycle_bin())

for index, value in enumerate(r):
    
    fileName = value.original_filename().split('\\')[-1]
    
    if fileName == "Ultimaker Cura 4.2":
        value.undelete()
        #print('I will undelete')
    
    """ if value.original_filename() == "F:\GitHub Repos\PlayingAround\PlayingAround\Python\TestingPythonScripts\deleteThis":
        value.undelete() """