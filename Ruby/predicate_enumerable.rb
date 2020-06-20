# a predicate enumerable is marked by a question mark (?)
# there return a boolean (true or false)

# the include? method is useful because it checks if the array includes something

# example using each:
numbers = [5, 6, 7, 8]
search_item = 6
result = false

numbers.each do |number|
  if number == search_item
    result = true
  end
end

# now lets do the same thing with include?

result = numbers.include?(6)

# this also works with strings (are you surprised? cause I'm not)
# let's host a party with some friends and only invite those we want

friends = ['Dipper', 'Mabel', 'Pacifica', 'Robby', 'Wendy']

invited_list = friends.reject { |friend| friend == 'Robby' }

invited_list.include?('Robby') #=> false

# the any? method will return true if any element evaluates to true

# Here's how we can do that with each
new_numbers = [21, 42, 303, 499, 550, 811]
result = false

new_numbers.each do |number|
  if number > 500
    result = true
  end
end

# now lets run that same thing with any?
new_numbers.any? { |number| number > 500 } # much simpler

# the all? method is similar to any? but with all? every element in an array needs to
# meet the criteria Let's check if all our friends names are 5 letters long

# doing it with each:
matches = []
result = false

friends.each do |friend|
  if friend.length == 5
    matches.push(friend)
  end

  result = friends.length == matches.length
end

# now lets do the same thing with all?

friends.all? { |friend| friend.length == 5 }

# the none? method is the exact opposite of all? it will return true only if
# none of the elements in the array match

# lets make sure none of our friends have a four letter name
# first with each
matches = []
result = false

friends.each do |friend|
  if friend.length == 4
    matches.push(friend)
  end

  result = matches.length == 0
end

# now how does it look with none?
friends.none? { |friend| friend.length == 4 }