import cv2 as cv

capture = cv.VideoCapture('Videos/dog.mp4')

# This function will take a frame, basically a cv matrix and a scale
# it will then resize it based on the information provided
# basically it's set up to best interact with the resize method
def rescaleFrame(frame, scale=0.75):
    # This function will work for stills, video, live capture, basically
    # if OpenCV can create a matrix of it, this function can resize it
    
    # The height and width need to be set using integers
    # not floats so we resize it with the scale and then cast to int
    width = int(frame.shape[1] * scale)
    height = int(frame.shape[0] * scale)
    dimensions = (width,height)
    
    # this is where the real magic happens, the resize method
    # will do the heavy lifting but it seems to need a tuple as the second
    # argument that will set the dimensions to the pixel that's what the
    # variables above are for
    return cv.resize(frame, dimensions, interpolation=cv.INTER_AREA)

# the set method is a way to resize a video (but not an image)
# the set method has an array of items that can be referenced
# the width is 3, the height is 4, and according to the tutorial the brightness is 10
# The documentation better have this recorded

# we're going to take a look at some of these using this function

def changeRes(width, height):
    # this will only work for live video
    # Such as a capture from your webcam
    capture.set(3,width)
    capture.set(4, height)

while True:
    isTrue, frame = capture.read()
    
    frame_resized = rescaleFrame(frame, .2)
    
    cv.imshow('Video', frame)
    cv.imshow('Video Resized', frame_resized)

    if cv.waitKey(20) & 0xFF==ord('d'):
        break

capture.release()
cv.destroyAllWindows()