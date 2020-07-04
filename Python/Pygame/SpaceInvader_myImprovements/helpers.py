import math

def checkCollision(x1, y1, x2, y2):
    distance = math.sqrt(math.pow((x1 - x2), 2) + math.pow((y1 - y2), 2))
    if distance <= 27:
        return True
    else:
        return False