# If your program encounters an error on runtime (you try to run the program and
# it fails), then it will print out a stack trace. A stack trace is a list of all
# the code that was executed before your program failed. You don't need to read
# the entirety of the stack trace, the first line will usually be the most useful.
# It's the most useful because it will print the line where the error occurred as
# well as some useful data like the type of error.

# Debugging is the process of confirming your assumptions through testing. If you
# think a block of code is working right, but it doesn't do what you expected it
# too, then you need to work through the code line by line.

# One of the basic debugging techniques is printing the value of variables to 
# the console. If you know what the value of a variable is in a specific instance
# than you should be able to tell what the next line of code will do.
# In Ruby, you can print variables to the console using puts or p.

# When debugging with puts, you might come across an instance where there isn't 
# anything printed, when you expect something to show up. That's why p is useful
# If you have a nil value being printed with puts, puts will print an empty line
# while if you use p it will print the variable so if you have an empty array "[]"
# and you print it with puts there will be nothing there, but if you use p it will
# print []

# Ruby has a gem called Pry, which will open a new IRB session when you call
# binding.pry at some point in your code. It is basically a breakpoint that you
# add by adding a line of code. You can check the value of variables in this IRB

# Another piece of good debugging advice is to take a break. If you walk away from
# your code after a long time of racking your brain for the solution to a bug, 
# quite often you will find that the problem was right in front of you the whole time

# A silly sounding, but useful debugging technique is Rubber Duck Debugging, basically
# you sit down and explain to a rubber duck (or any desk toy, or person who doesn't know
# anything about your code) what each line of your code does. This forces you to think
# through the things your code is suppose to do and you will usually find the error.