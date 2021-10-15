import cv2 as cv
import numpy as np

# This file is to draw on an image. There are multiple ways to draw on an image
# one was is to create a blank image and draw on that. That is the first
# way that the instructor is going to go over.

# I decided I wanted to have several different variable blank images to mess with
# so I created a simple class so I can create them really easy
class EmptyImg:
    def __init__(self, height=500, width=500):
        self.h = height
        self.w = width
        self.img = np.zeros((height, width, 3), dtype='uint8')

blank = EmptyImg()
cv.imshow('Blank', blank.img)

# We are going to first paint the image a certain color

# Here I'm creating a new image and then coloring in green.
# obviously I would use a class method to set colors, but I don't want to get that
# deep into it right now
green = EmptyImg()
green.img[:] = 0, 255, 0
cv.imshow('Green', green.img)

# Now I'm going to select only a portion of the pixels and color them red
red = EmptyImg()
red.img[200:300, 300:400] = 0, 0, 255
cv.imshow('Red', red.img)

# Now We will draw a rectangle
rect = EmptyImg()
# We can either have an outline of a rectangle by setting the thickness in
# the rectangle method to an integer, or we can use cv.FILLED and it will
# fill it in, -1 will also fill it in
cv.rectangle(rect.img, (0, 0), (rect.img.shape[1]//2, rect.img.shape[0]//2), (255, 0, 0), thickness=2)
cv.imshow('Rectangle', rect.img)

# Now we will draw a cicle using the cirle method
# the circle method is similar to the rectangle method
# but instead of specifing the top left and bottom right corners you
# specify the center and the radius
# you can use the thickness in the same way as the rectangle
circ = EmptyImg()
cv.circle(circ.img, (250, 250), 40, (0, 255, 255), thickness=3)
cv.imshow('Circle', circ.img)

# The line method is pretty straight forward as well
line = EmptyImg()
cv.line(line.img, (0, 0), (250, 250), (255, 255, 255), thickness=3)
cv.imshow('Line', line.img)

# Now we will go over adding text to an image

textImg = EmptyImg()
cv.putText(textImg.img, 'Hello, This is a longer thing!', (5, 225), cv.FONT_HERSHEY_TRIPLEX, 0.9, (0, 255, 0), 2)
cv.imshow('Text', textImg.img)

cv.waitKey(0)