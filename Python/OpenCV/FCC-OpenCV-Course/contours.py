import cv2 as cv
import numpy as np

img = cv.imread('Photos/cats.jpg')
cv.imshow('Cats', img)
gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

blank = np.zeros(img.shape, dtype='uint8')

# blur = cv.GaussianBlur(img, (5, 5), cv.BORDER_DEFAULT)
# canny = cv.Canny(blur, 125, 175)
# cv.imshow('Canny Edges', canny)

# Find Contours will provide two vairables, a list of the found contours
# and a hierarchy of all the found contours

ret, thresh = cv.threshold(gray, 125, 255, cv.THRESH_BINARY)
cv.imshow('Thresh', thresh)

contours, hierarchies = cv.findContours(thresh, cv.RETR_LIST, cv.CHAIN_APPROX_SIMPLE)

print(f'{len(contours)} contour(s) found')

cv.drawContours(blank, contours, -1, (0, 0, 255), 1)
cv.imshow('Contours Drawn', blank)

cv.waitKey(0)