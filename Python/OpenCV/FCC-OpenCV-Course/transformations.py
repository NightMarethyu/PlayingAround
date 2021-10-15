import cv2 as cv
import numpy as np

img = cv.imread('Photos/park.jpg')
cv.imshow('Boston', img)

# Image Translation
# just moving the image around on the x and y axis
# we are going to use a function to do the tranlation
def translate(img, x, y):
    # the x does left and right (negetive, positive respectively)
    # y does up and down (negetive, positive respectively)
    transMat = np.float32([[1,0,x], [0,1,y]])
    dims = (img.shape[1], img.shape[0])
    return cv.warpAffine(img, transMat, dims)

translateImg = translate(img, -100, 100)
cv.imshow('Translated', translateImg)

# Rotation
# OpenCV lets you specify any point on the image to rotate it
# we will create a function that has the following arguments
# an image to be rotated
# the degree of an angle to rotate
# the point to rotate around
def rotate(img, angle, rotPoint=None):
    (height, width) = img.shape[:2]
    
    if rotPoint is None:
        rotPoint = (width//2, height//2)
    
    # the angle will rotate the image counter-clockwise by default
    # if you add a negative angle it will rotate clockwise
    rotMat = cv.getRotationMatrix2D(rotPoint, angle, 1.0)
    dims = (width, height)
    
    return cv.warpAffine(img, rotMat, dims)

rotateImg = rotate(img, 45)
cv.imshow('Rotated', rotateImg)

# You can rotate a rotated image but since some of the pixels will
# have left the image dimensions, it doesn't display them
rot_rot = rotate(rotateImg, 45)
cv.imshow('Rotated Rotation', rot_rot)

# flip an image
# the second argument in the flip method is the flipCode
# a value of zero is flipping over the x axis, 1 will flip over the y
# and a value of -1 will flip over both
flip = cv.flip(img, -1)
cv.imshow('Flip', flip)

cv.waitKey(0)