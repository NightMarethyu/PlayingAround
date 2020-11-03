# Lists: ordered, mutable, allows duplicate elements

# A list is a collection datatype

mylist = ["banana", "cherry", "apple"]
print(mylist)

mylist1 = [5, True, "apple", "apple"]
print(mylist1)

item = mylist[1]
print(item)

for thing in mylist:
    print(thing)
    
# You can use negative numbers to specify items in a list
# for example

print(mylist[-1])

# This line prints "apple" because it is the last item in the list

val = "cherry"
#input("Enter a fruit: ")

if val in mylist:
    print("yes")
else:
    print("no")
    
# len method is a useful way to check the length of a list
print(len(mylist))

# append can be used to add things to the end of a list
mylist.append("lemon")
print(mylist)

# adding an item at a specific position is done with the insert method

mylist.insert(1, "watermelon")
print(mylist)

# the pop method will return the last item and remove it

newItem = mylist.pop()
print(newItem)
print(mylist)

# removing a specific element is done with the remove method
# the clear method will make the list an empty list
# reverse will reorder the list
# the sort method will organize the list

mylist2 = [4, 2, 1, -2, -4, 10, 13]
print(mylist2)

sortList = sorted(mylist2)
print(mylist2)
print(sortList)

# adding lists with a bunch of duplicate items can be done with multiplication

multiList = [0] * 5
print(multiList)

# concatinating lists can be done with addition

mylist3 = mylist + multiList
print(mylist3)

# Accessing subparts of a list can be done with slicing
# easily do this with a : add a start and stop index and it will take just the
# specified portion of the list
# not specifying the start or stop it will either start at the beginning or run
# to the end
# specifying the step index will allow it to skip entries

slicedList = mylist3[::2]
print(slicedList)

# adding a negative step index will reverse your list

list_org = ["banana", "cherry", "apple", "pomegranate"]

list_cpy = list_org.copy()
list_cpy.append("lemon")

print(list_cpy)
print(list_org)

# there are several ways of copying a list to a new list
# just using the = will refer to the same space in memory
# to make a true copy use the copy method or the list
# function and pass the original list in as an argument or
# using slicing and refer to the whole list with [:]

# we can also modify copies of lists with a one line loop

a = [1, 2, 3, 4, 5, 6]
b = [i*i for i in a]

print(a)
print(b)