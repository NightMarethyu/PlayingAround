import cv2 as cv

# First we need to bring the image into python with the cv.imread method
# This method returns a matrix of pixels which we can then work with as a variable
# This method needs a string path to the image
img = cv.imread('Photos/cat_large.jpg')

# Next we will display the image using the imshow method
# This method will open a new window and display the image
# It needs two inputs, the name of the window and a matrix of pixels
cv.imshow('Cat', img)

# this line keeps the image window open until a key is pressed
cv.waitKey(0)