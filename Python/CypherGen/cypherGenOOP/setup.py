from distutils.core import setup
import py2exe

setup(
    console = [
        {
            "script": "main.py",                    ### Main Python script    
            "icon_resources": [(0, "bill-cipher.ico")]     ### Icon to embed into the PE file.
        }
    ],
)