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