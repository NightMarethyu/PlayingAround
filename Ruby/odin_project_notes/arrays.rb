# ruby arrays are 0 based, like a lot of other languages
# An article I just read explained the reason that most other languages are 0 based
# if you think of an array as a type of linked list than the head is 0 and the rest of the
# array is numbers that follow. This may not be clear to others, but I understand the idea

# ruby allows you to access elements in an array using a negative index, which will select the
# item in the array starting from the last

# example
str_array = ["this", "is", "an", "array", "of", "strings"]

str_array[0] #=> "this"
str_array[-1] #=> "strings"

# you can add items to an array using push or the "shovel" operator <<
# you can remove and return items from an array using pop

# example
num_array = [1, 2]

num_array.push(3, 4) # [1, 2, 3, 4]
num_array << 5 # [1, 2, 3, 4, 5]
num_array.pop # returns 5 num_array = [1, 2, 3, 4]

# shift and unshift allow you to add and remove the first item in an array
# shift is like pop, it will remove and return the first item in an array
# unshift will add a new first item to an array

# example
num_array = [2, 3, 4]

num_array.unshift(1) # [1, 2, 3, 4]
num_array.shift # returns 1 num_array = [2, 3, 4]

# pop and shift can take integer arguments
# you can take the last 3 items from an array using myarray.pop(3)

# arrays can be combined using concatination
a = [1, 2, 3]
b = [4, 5, 6]

c = a + b # c = [1, 2, 3, 4, 5, 6]

# subtracting arrays returns the difference between the arrays

[1, 1, 1, 1, 2, 3, 4, 4] - [1, 4] # [2, 3]

# ruby has a to_s method for arrays, you can print an array as a string with this method
# if you add an array to a string using #{x} formatting ruby will automatically call the to_s method