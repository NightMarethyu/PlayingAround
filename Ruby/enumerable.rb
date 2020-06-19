# This lesson is about different ways to loop through arrays and hashes
# Ruby has a bunch of built-in methods because this is such a common thing

# the select enumerable is one way to cut down on really basic for loops in
# an array in Ruby

# in the following examples we will loop over the array and select everyone
# except Lila (you know what you did)
friends = ['Marinette', 'Adrien', 'Lila', 'Alya', 'Nino']
invited_list = []
invited_list_2 = []
invited_list_3 = []

# For loop example
for friend in friends do
  if friend != 'Lila'
    invited_list.push(friend)
  end
end

# Now do the same thing with the select method
invited_list_2 = friends.select { |friend| friend != 'Lila'}

# The reject method is more to the point
# remember the goal is to not use ! (not) it's easier to read and more logical
invited_list_3 = friends.reject { |friend| friend == 'Lila'}

# the each method is one of the most versitile methods when working with an array or hash
# the each method is a loop that will work with "each" of the items in the array or hash
# basically its for each item in array or our previous loop 'for friend in friends do'

# example
friends.each { |friend| puts "Hello, " + friend}

# that same thing can be written
for friend in friends do
  puts "Hello, " + friend
end

# if you need more logic than one line of code use do...end
friends.each do |friend|
  if friend == 'Lila'
    puts friend + "'s a big liar"
  else
    puts "Hello, " + friend
  end
end

# you can also do this with hashes but keep in mind hashes will return not just the
# value but the key as well

# example
num_hash = { "one" => 1, "two" => 2}

num_hash.each { |key, value| puts "#{key} is #{value}"}

# this will print ($ one is 1\n two is 2\n)

# if you only use one variable in the |...| then you will get an array of a key and value

# quick note the each method will return the unaltered array regardless of the code block
# this could cause problems if you aren't expecting it take our friends array for example
# let's say we wanted it in uppercase and wrote this code:
friends.each { |friend| friend.upcase }

# this won't return the uppercase version of the names, but the original names

# the each_with_index method is similar to each, but instead of just the variable,
# this gives you a second varible to work with the item's index in the array
# if you needed only the even items printed:
friends.each_with_index { |friend, index| puts friend if index.even? }

# since each and each_with_index don't modify the array we would need to add
# a bunch of code to modify the array so instead Ruby has a method called map
# map will modify the original array so we don't need as much logic

# let's say we wanted an uppercase version of our friends names

friends_shouting = ['Marinette', 'Adrien', 'Lila', 'Alya', 'Nino']

friends_shouting.map { |friend| friend.upcase }

# the reduce method is a pretty complex one, let's see if I can't explain it simply
# reduce has two variables what is being reduced and the item in the array

# easiest example is as a basic sum calculator
lilas_lies = [7, 9, 13, 5]

lilas_lies.reduce { |sum, number| sum + number } # this will return 34

# so what's happening here? well the reduce method is taking the empty variable 'sum'
# and for each loop it is adding the number in the array in a for loop
# let's write this out using the each method

sum = 0
lilas_lies.each { |number| sum += number } # sum will now be 34

# okay so let's look at another way we can use this reduce method
# maybe you need to do some voting let's ask our friends list if they think Lila is a liar

is_lila_a_liar = ['yes', 'yes', 'no', 'maybe', 'maybe']

is_lila_a_liar.reduce(Hash.new(0)) do |result, vote|
  result[vote] += 1
  result
end

#=> {'yes'=>2, 'no'=>1, 'maybe'=>2}

# so it looks like Lila is probably a liar. But what did we do with the Hash.new(0)?
# the reduce method allows you to add an initial modifier, so going back to our basic
# calculator, if we wanted to start at 1000 and add to it we would do this:
lilas_lies.reduce(1000) { |sum, number| sum + number } # this will return 1034

# rather than start at zero with an empty variable called sum, it starts with a variable
# called sum = 1000 and adds the values in the array

# so let's tie this initial modifier and voting reduce method together and explain it
# we first assigned this new Hash to have a default value of 0 so as soon as we add a key
# that kew will have the default value 0, so for each pass of the reduce method it will do this:

### FIRST PASS ###
# result = {}
### SECOND PASS ###
# result['yes'] += 1 (remember result['yes'] has a default value of 0 so this will be 0+1)
### THIRD PASS ###
# result['yes'] += 1 (now this has a value of 2)
### FOURTH PASS ###
## Here's where it gets interesting
# result['no'] += 1
# now result = { 'yes'=>2, 'no'=>1 }
### FIFTH PASS ###
# result['maybe'] += 1
### SIXTH PASS ###
# result['maybe'] += 1

#=> result = {'yes'=>2, 'no'=>1, 'maybe'=>2}

# Let's revist map for a second, the map method will return a modified array, but
# our friends_shouting array will still not be uppercase but we wanted to store our
# uppercase friend's names in that array. This is where the "bang" methods come in

friends_shouting.map! { |friend| friend.upcase}

# now all the names in our friends_shouting array are uppercase

# most enumberable methods have a "bang" (!) version, but it's not usually best practice
# to use these, we usually want to keep our original data as it is, this protects the data
# you might be asking, what if we need to reuse the data regularly? isn't it a waste of 
# resources to recalculate things repeatedly? You're right, it's dumb to recalculate things
# so it's a better idea to store data in a variable, or use a method definition

# let's add a def for our list that excludes the liar Lila

def no_lila(friends)
  friends.reject { |friend| friend == 'Lila' }
end

no_lila(friends)
# this will return the array ['Marinette', 'Adrien', 'Alya', 'Nino']