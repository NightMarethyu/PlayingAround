# A tuple is a collection datatype
# Tuple: ordered, immutable, allows duplicate elements

myTuple = ("Jack", 36, "Military")
print(myTuple)

# Parentheses are optional, defining a tuple can be done without them

noParentheses = "John", 24, "Barber"
print(noParentheses)

# Just adding parentheses is not enough to define a tuple
# if there is only one item it must have a comma after the item

notATuple = ("Tohru")
print(type(notATuple))
aTuple = ("Kanna",)
print(type(aTuple))

# The built in tuple() function will make it possible to create
# a tuple from an iterable, a list or similar variable

randomList = ["Kazuma", "Aqua", "Megumin", "Darkness"]
tupleFunction = tuple(randomList)
print(type(randomList), randomList)
print(type(tupleFunction), tupleFunction)

# accessing items in a tuple is done the same way as a list
# the tuple name and then [] with an index number
# a negative index works the same way as a list

# as tuples are iterables you can use the for ... in ...
# and if ... in ... to loop over the items or check if a 
# value is in a tuple

testing = tuple(randomList)

for x in testing:
    print(x)

if "Aqua" in testing:
    print("yes")
    
# most list methods will also work with tuples
# the count method will count how many of a specific item are in a tuple

newList = [0] * 5
newList1 = [2] * 3

listCon = newList + newList1

couTuple = tuple(listCon)
print(len(couTuple))
print(couTuple.count(2))

# the index method will let you check for the index of the first
# of an item in the tuple

print(testing.index("Megumin"))

# slicing can be done on tuples just like on lists

# tuples can be "unpacked" meaning you can assign the value of
# the items in a tuple to variables

mc, useless, tsarBomba, meatShield = testing

print(mc)
print(useless)
print(tsarBomba)
print(meatShield)

# if the number of items you unpack don't match the number of items
# in the tuple it will throw an error. This can be avoided by using
# the *variable, this will convert these items into a list,
# here's an example

nisekoi = ("Ichijo", "Kirisaki", "Marika", "Tsugumi", "Onodera")

mainChara, *girls, bestGirl = nisekoi
print(mainChara)
print(bestGirl)
print(girls)

# since tuples are immutable they use fewer bytes than lists
# so they can be faster depending on the data you are working with