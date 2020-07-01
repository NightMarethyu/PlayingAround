### OBJECT ORIENTED PROGRAMMING

# Classes in Ruby are created by using the class keyword
# Conventionally classes are named using CamelCase with a capital on the first word


# Sample class from Codeacademy
class Language
  def initialize(name, creator)
    @name = name
    @creator = creator
  end
	
  def description
    puts "I'm #{@name} and I was created by #{@creator}!"
  end
end

ruby = Language.new("Ruby", "Yukihiro Matsumoto")
python = Language.new("Python", "Guido van Rossum")
javascript = Language.new("JavaScript", "Brendan Eich")

ruby.description
python.description
javascript.description

# Another Sample class from Codeacademy
class Computer
  $manufacturer = "Mango Computer, Inc."
  @@files = {hello: "Hello, world!"}
  
  def initialize(username, password)
    @username = username
    @password = password
  end
  
  def current_user
    @username
  end
  
  def self.display_files
    @@files
  end
end

# Make a new Computer instance:
hal = Computer.new("Dave", 12345)

puts "Current user: #{hal.current_user}"
# @username belongs to the hal instance.

puts "Manufacturer: #{$manufacturer}"
# $manufacturer is global! We can get it directly.

puts "Files: #{Computer.display_files}"
# @@files belongs to the Computer class.

# In Ruby, all instance variables must start with @
# Class variables start with two @s like @@files
# Global variables are defined with $

# Classes can inherit from other classes using < inheritance
# So if you have a general PlayerCharacter class and you want Elf to inherit it
# you would use class Elf < PlayerCharacter

# You can override a method from an inherited class by defining a method of the same
# name. But if you need the information that would be returned by that method
# you can use the keyword super to access it in the method being called.
# That may not be super clear so I'll include the code from Codeacademy for reference

# Example code:
class Creature
  def initialize(name)
    @name = name
  end
  
  def fight
    return "Punch to the chops!"
  end
end

# Add your code below!
class Dragon < Creature
  def fight
    puts "Instead of breathing fire..."
    super
  end
end

# Ruby doesn't allow for multiple superclass inheritance, meaning, if you want to have
# the attributes of more than one class in another class you can't do it using inheritance
# This is actually to prevent the developer from adding too many classes together and
# causing problems. There is a thing called "mixins" that allows for something similar
# but they don't want to go into that right now.

## Code Academy Object Oriented Programming Part 1 Review:
class Message
  @@messages_sent = 0

  def initialize(from, to)
    @from = from
    @to = to
    @@messages_sent += 1
  end
end

class Email < Message
  def initialize(from, to)
    super
  end
end

my_message = Message.new("Dipper", "Pacifica")

## Code Academy Virtual Computer:
class Computer
  @@users = Hash.new

  def initialize(username, password)
    @username = username
    @password = password
    @@users[username] = password
    
    @files = Hash.new
  end

  def create(filename)
    @time = Time.now
    @files[filename] = @time
    puts "Filename: #{@filename}, User: #{@username}, Time: #{@time}"
  end

  def Computer.get_users
    @@users
  end
end

my_computer = Computer.new("Bill", "BuyGold")

## Code Academy Object Oriented Programming Part II

# Ruby has both public an private methods for classes. They are declared using the
# keywords public and private. 

# We can access variables in a class using attr_reader and attr_writer. If we pass
# the names of our variables as symbols to attr_reader and attr_writer we can read
# or modify them without writing our own methods.

# if we have a variable that we want to both read and write, we don't need to add
# attr_reader and attr_writer we can use attr_accessor to do both.

# EXAMPLE
class Person
  attr_reader :name
  attr_accessor :job
  
  def initialize(name, job)
    @name = name
    @job = job
  end
end

# Modules can store things useful bits of code, but unlike classes they can't have
# subclasses and can't create instances. It's just a way to get things used frequently
# out of the way in a different file.

# Modules are named with CamelCase, just like classes. It goes against best practice to
# include a variable in a module because you don't change things in modules.
# But it is a very good idea to store constants in modules since they don't change.

# Remember constants in Ruby are written in ALL_CAPS, Ruby will allow you to change a 
# constant after it has been initialized, but it will warn you that you are trying
# to change a constant.

module MyLibrary
  FAVE_BOOK = "Is It Wrong to Try to Pick Up Girls in a Dungeon?"
end

# Ruby has a scope resolution operator, a way to tell where a specific variable is located
# the Ruby Math module has a constant called PI which can be accessed with Math::PI

# Some modules are included in the interpreter by default like Math, but others need to
# be included using require 'module' Just like include in Python

# there is also the keyword include so it's exactly like Python in that way.

class Angle
  include Math
  attr_accessor :radians
  
  def initialize(radians)
    @radians = radians
  end
  
  def cosine
    cos(@radians)
  end
end

acute = Angle.new(1)
acute.cosine

# using modules inside classes is called a mixin. You can write a method
# in a module and then include it in a class and access the method when
# you call an instance of that class with the method.

# EXAMPLE
module Action
  def jump
    @distance = rand(4) + 2
    puts "I jumped forward #{@distance} feet!"
  end
end

class Rabbit
  include Action
  attr_reader :name
  def initialize(name)
    @name = name
  end
end

class Cricket
  include Action
  attr_reader :name
  def initialize(name)
    @name = name
  end
end

peter = Rabbit.new("Peter")
jiminy = Cricket.new("Jiminy")

peter.jump
jiminy.jump

# include allows an instance of a class to use the module's methods
# but if you use extends the class itself can use the methods

# EXAMPLE
# ThePresent has a .now method that we'll extend to TheHereAnd

module ThePresent
  def now
    puts "It's #{Time.new.hour > 12 ? Time.new.hour - 12 : Time.new.hour}:#{Time.new.min} #{Time.new.hour > 12 ? 'PM' : 'AM'} (GMT)."
  end
end

class TheHereAnd
  extend ThePresent
end

TheHereAnd.now

# Codecademy Banking on Ruby Assignment:

class Account
  attr_reader :name, :balance
  
  def initialize(name, balance=100)
    @name = name
    @balance = balance
  end

  public
  def display_balance(pin_number)
    pin_number == pin  ? (puts "Balance: $#{@balance}") : (puts pin_error)
  end

  def withdraw(pin_number, amount)
    if pin_number == pin
      @balance -= amount
      puts "Withdrew #{amount}. New balance: $#{@balance}."
    else
      puts pin_error
    end
  end

  private
  def pin
    @pin = 1234
  end

  def pin_error
    return "Access denied: incorrect PIN."
  end
end

checking_account = Account.new("Bezos", 163_300_000_000)

### Launch School OOP Book

# Exercises
# 1) How do we create an object in Ruby
class ThisIsAnObject
end

# 2) What is a module? What is it's purpose?
# A module is piece of code we want to use in multiple places, Ruby has several
# built-in modules such as Math. To "mixin" our modules with ourclases we use
# include Module in the class
module PrintName
  def display_object_name(name)
    puts name
  end
end

# Launch School OOP Classes and Objects 1
# Exercises

# 1) Create a class called MyCar
class MyCar
  attr_accessor :year, :color, :model, :speed

  def initialize(year, color, model)
    self.year = year
    self.color = color
    self.model = model
    self.speed = 0
  end

  def speed_up(increase)
    self.speed += increase
  end

  def brake(decrease)
    self.speed -= decrease
  end

  def car_off
    self.speed = 0
    puts "The car color #{self.color}, year #{self.year}, and model #{self.model} is now off"
  end

  def cur_speed
    puts "You current speed is #{self.speed}"
  end

  def spray_paint(color)
    self.color = color
    puts "Your car is now #{self.color}"
  end
end

# Above I took a note about overwriting inherited methods. Well Ruby allows that
# for any method including built in methods. Say for instance you wanted
# to print some information when you use "puts instance_name" you could
# write a .to_s method in your class that will print specific information
# as opposed to the inbuilt .to_s method that would print something like
# this #<MyClassName:0x0000ff>

# keep in mind that overwriting this could cause some unexpected behavior if
# you forget that you've overwritten an inbuilt method. Like if you overwrote
# to_s then when you used string interpolation, #{instance_name} it would
# add the overwritten information from your custom to_s method

## Classes and Objects Part II
# Exercises

# 1) Add a class method that calculates the gas milage of any car
# 2) override the to_s method to create a userfriendly printout
class MyCar
  attr_accessor :year, :color, :model, :speed

  def initialize(year, color, model)
    self.year = year
    self.color = color
    self.model = model
    self.speed = 0
  end

  def speed_up(increase)
    self.speed += increase
  end

  def brake(decrease)
    self.speed -= decrease
  end

  def car_off
    self.speed = 0
    puts "The car is now off"
  end

  def cur_speed
    puts "You current speed is #{self.speed}"
  end

  def spray_paint(color)
    self.color = color
    puts "Your car is now #{self.color}"
  end

  def self.mileage(gal, mile)
    puts "#{mile/gal} miles per gallon"
  end

  def to_s
    "The car with color #{self.color}, year #{self.year}, and model #{self.model}"
  end
end

# 3) The code gives an error because the class Person only has an attr_reader
# to fix it you would need to change attr_reader to attr_accessor or attr_writer

## Launch School Inheritance

# a common naming convetion is to add the "able" suffix on a verb that describes
# the behavior the module is modeling.

# using the .ancestors method to view the inheritance of a class tells us that
# the order in which things are implemented is important. We can override
# methods, just by changing the order in which we add the code.

# we can use modules to contain classes and methods so we can abstract our code
# and have things contained in separate locations.