# Ruby is a purely object-oriented programming language
# normally you would have fuctions and methods in a language
# but in Ruby everything is associated with an object therefore
# there are no fuctions only methods
# This doesn't mean that you can't have functions they are just called
# methods because Ruby

# Ruby has a bunch of built in methods the Enumerable lessons are all about
# some of Ruby's built in methods for arrays and hashes

# there are global methods though, like print and puts which can be called
# without using the dot notation that is found on so many other methods
# Ruby has optional parantheses, so some methods, like puts don't require
# paratheses

# we can write puts like this:
puts "Hello, world"

# or like this:
puts("Hello, world")

# both do the same thing, but Ruby doesn't require that we use paratheses

# We can build our own methods using the Ruby keyword "def"
# this will "define" a new method

# normally in Ruby a method is named using snake_case if it contains more than
# one word, this isn't required but it will make your code more readable

# here are rules for naming methods:
# 1) You cannot use a Ruby reserved keyword, such as end, while, or for
# 2) Only the symbols _, ?, !, and = can be used so no # or *
# 3) symbols ?, !, and = can be at the end of the method name, nowhere else
# 4) You cannot start a method name with a number (5five isn't' allowed but five5 is)

# To make your code more "future proof" you should always use descriptive method names
# don't call your method do_something, because then you need to read all the lines of
# that method to remember what that something is, call it what it does like invite_friends

# more advice, if your method is doing more than one thing, break it up and call the methods
# elsewhere in your code. If you have a method that is excluding your friend Bill from the
# invite list and it's sending invites, and marking Pacifica as super rich make those
# into separate methods, then you can call them in different places and you cut down on code

### PARAMETERS AND ARGUMENTS

# Adding parameters allows your methods to do more stuff. If you include a parameter it is a
# variable that will interact with the code in your method. An argument is the value being passed
# to that parameter. Since these two concepts are similar they are often used interchangably

# Example

def greet(name)
  "Hello, " + name + "!"
end

puts greet('Dipper') #=> Hello, John!

# Default Parameters
# it's sometimes a good idea to include a default value for your parameters. If you do that
# your methods will be able to run both with and without items in paratheses, like the 
# reduce method from the enumberable section. The default parameter there is empty, but you 
# can add a parameter to improve it's functionality

# Example
def hello(name = "stranger")
  "Hello, " + name + "!"
end

puts hello("Mabel") #=> Hello, Mabel!
puts hello #=> Hello, stranger!

### RETURN

# Ruby is one of few languages that has implicit return, basically the last thing
# that a method does will be returned, regardless of whether there is a return keyword
# in Python for example you need to say "return var" for it to return a variable named var
# in Ruby you just need it to evaluate whatever var is

# Example
def even_odd(number)
  if number % 2 == 0
    "That is an even number"
  else
    "That is an odd number"
  end
end

puts even_odd(16) #=> That is an even number

# While implicit return is something useful for concise code, explicit return is still
# used in Ruby. Let's make our even_odd method more bug resistant by adding explicit return

# example
def even_odder(number)
  unless number.is_a? Numeric
    return "A number was not entered"
  end

  even_odd(number) # Trying to practice DRY, and I'm too lazy to be bothered to copy and paste
end

puts even_odder("Ruby") #=> A number was not entered

# PUTS vs RETURN
# puts will print things to the console like python's print and c's printf functions
# return will save the evaluation of the method's code
# apparently this is confusing to some people. Hopefully I can clear some of that confusion
# Everything in Ruby has a return value, the return value for puts is nil, so if you have 
# puts as the last thing being evaluated by your method it will return nil and the
# method will return nil as well, hopefully that's clearer, but these are my notes for me
# if they don't help you then read someone else's notes

### Chaining methods

# Ruby along with many other OOP languages allows you to chain methods
# let's use puts to print an array, this will be an array of words we want
# printed

# Example
phrase = ["Aoshima!", "Onwards,", "past!", "the", "in", "is", "future", "the"]
puts phrase.reverse.join(" ").capitalize #=> The future is in the past! onwards, aoshima!

# we could do that one at a time, but that's obnoxious
new_phrase = phrase.reverse #=> ["the", "future", "is", "in", "the", "past!", "Onwards,", "Aoshima!"]
new_phrase = new_phrase.join(" ") #=> "the future is in the past! Onwards, Aoshima!"
new_phrase = new_phrase.capitalize #=> "The future is in the past! onwards, aoshima!"
puts new_phrase

# Predicate methods are methods that return a boolean value. These methods end in ? so they
# are easy to identify. You can add a ? to the end of your method names to indicate that
# they are predicate methods, but you don't have to. It is best practice though so please
# only add a ? if you are returning a boolean, I thank you and so will others who look at
# your code (yourself included)

# Another convetion in Ruby is ! (bang) methods. If a method ends with ! it is considered
# a dangerous method, because it modifies what is calling it. Not all methods have a !
# equivalent, but many do. If you are writing a method that modifies the original object
# you should add a ! to indicate that, (again this is just to make people happy, it's not
# required)

# Example
name = "grunkle stan"
puts name.upcase #=> GRUNKLE STAN
puts name #=> grunkle stan

# alternatively
puts name.upcase! #=> GRUNKLE STAN
puts name #=> GRUNKLE STAN

# writing name.upcase! is the same as writing name = name.upcase
