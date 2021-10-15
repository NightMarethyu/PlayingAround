import cv2 as cv

# reading videos is different from images (duh) we need to 
# first use a capture variable with the method VideoCapture
# then read the video in a while loop

# the VideoCapture method can capture video directly from a camera
# most likely a webcam, use an integer to select the camera 0 being the default
# or you can pass a string path to a video
capture = cv.VideoCapture('Videos/dog.mp4')

while True:
    # Once the video reaches the end, it will throw a -215:Assertion failed
    # error, this means that OpenCV can't find a media file at the specified
    # location.
    isTrue, frame = capture.read()
    cv.imshow('Video', frame)
    
    # this code lets you get out of the video playback by pressing the letter d
    # on the keyboard
    if cv.waitKey(20) & 0xFF==ord('d'):
        break

capture.release()
cv.destroyAllWindows()