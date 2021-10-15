# This is about some of the basic functions in OpenCV
import cv2 as cv

img = cv.imread('Photos/park.jpg')
cv.imshow('Park', img)

# convert an image to grayscale
gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)
cv.imshow('Gray', gray)

# Blur an image
# The second arg is the ksize or kernel size, it needs to be
# a 2x2 tuple, the bigger this number the more the blurriness
# will increase. The instructor says he will cover more
# about blurs and the different types of blurs later in the course
blur = cv.GaussianBlur(img, (7, 7), cv.BORDER_DEFAULT)
cv.imshow('Blur', blur)

# Edge Cascade, (edge detection)
# you can have it find lots of edges with the raw image, or fewer
# edges by passing in a blurred image
canny = cv.Canny(blur, 125, 175)
cv.imshow('Canny Edges', canny)

# Dilating the Image
# from what I can see, this takes the outlines provided by the 
# edge detection and makes them bigger
dilated = cv.dilate(canny, (7,7), iterations=3)
cv.imshow('Dilated', dilated)

# Eroding
# this does basically the opposite of Dilating the image
eroded = cv.erode(dilated, (7,7), iterations=3)
cv.imshow('Eroded', eroded)

# Resize
resized = cv.resize(img, (500, 500), interpolation=cv.INTER_CUBIC)
cv.imshow('Resized', resized)

# Cropping
# we can just manipulate the array of pixels using array slicing
cropped = img[50:200, 200:400]
cv.imshow('Cropped', cropped)

cv.waitKey(0)