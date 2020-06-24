# hashes are similar to Python Dictionaries, so if you are familiar with those
# then you have some amount of familiarity with hashes

# hashes are made with the Hash literal {}
# keys and values are associated using the hash rocket =>
# hashes can also be made using Hash.new like arrays and Array.new

# example
my_hash = {
  "a random word" => "ahoy",
  "Dorothy's math test score" => 94,
  "an array" => [1, 2, 3],
  "an empty hash within a hash" => {}
}

new_hash = Hash.new

# values in a hash are accessed by using the hash name followed by the key in
# square brackets [] just like an array

# example
shoes = {
  "summer" => "sandals",
  "winter" => "boots",
  "spring" => "running shoes",
  "fall" => "tennis shoes"
}

puts shoes["summer"] #=> "sandals"

# attempting to access a non-existant key will return nil

# example
shoes["outdoors"] #=> nil

# returning a nil value could cause problems so hashes have a built in
# fetch method that will throw an error rather than break something

# example
shoes.fetch("outdoors") #=> KeyError: key not found "outdoors"

# you can also use fetch to return a default value if the key isn't found

shoes.fetch("outdoors", "hiking boots") #=> "hiking boots"

# adding or modifying keys and values to a hash is just like any other varible

# example
shoes["work"] = "steel toe boots"

shoes["summer"] = "flip-flops"

# removing data from a hash is easy just run the delete method
# this will also return the value of the key-value pair that was deleted

shoes.delete("summer") #=> "flip-flops"
shoes #=> {"winter"=>"boots", "fall"=>"tennis shoes", "spring"=>"running shoes", "work"=>"steel toe boots"}
# remember hashes aren't ordered like arrays, they have keys so they can be in any order

# two hash specific methods are keys and values, they return the keys or the values of a hash

# example
shoes.keys #=> ["winter", "fall", "spring", "work"]
shoes.values #=> ["boots", "tennis shoes", "running shoes", "steel toe boots"]

# combining two hashes is as easy as merge
# just call the merge method on one hash and add the other hash as an argument

# example
hash1 = { "a" => 100, "b" => 200 }
hash2 = { "b" => 254, "c" => 300 }

hash1.merge(hash2) #=> { "a" => 100, "b" => 254, "c" => 300 }
# note the values in hash that is being called will be overwritten if the 
# key matches in the hash that is being merged in

# using strings as keys is not best practice in Ruby, instead you should use a symbol
# symbols are represented by a colon followed by text with underscores instead of
# spaces (snake_case)

# example
japanese_cars = {
  honda: "Accord",
  toyota: "Corolla",
  nissan: "Altima"
}

# note you can use more standard symbols (i.e. :honda) and a hash rocket =>
# but why do that when this is clear and easier to type

# to access keys as symbols though you still need to use standard symbol syntax

japanese_cars[:honda] #=> "Accord"


##########################################################
# Launch School Notes

# you can iterate over hashes using the each method

# example
person = {name: 'bob', height: '6 ft', weight: '160 lbs', hair: 'brown'}

person.each do |key, value|
  puts "Bob's #{key} is #{value}"
end

# the to_a method for a hash converts a hash into a two-dimensional array
# it's non-destructive too so you can still access the hash like normal

# example
person.to_a #=> [[:name, "bob"], [:height, "6 ft"], [:weight, "160 lbs"], [:hair, "brown"]]

# Launch School Exercises
# Exercise 1

family = {  uncles: ["bob", "joe", "steve"],
  sisters: ["jane", "jill", "beth"],
  brothers: ["frank","rob","david"],
  aunts: ["mary","sally","susan"]
}

new_arr = family.select {|k,v| (k == :sisters) || (k == :brothers)}
new_arr = new_arr.values.flatten

p new_arr

# Ruby has two merge methods for hashes merge and merge!
# merge returns a new has while merge! modifies the given hash

