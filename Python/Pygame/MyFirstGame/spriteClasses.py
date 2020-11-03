import os, pygame

import settings

class Platform:
    def __init__(self, screen, clock, manager, x, y, rectangle):
        self.rectangle = pygame.Rect((rectangle), (x, y))
        

class Player:
    def __init__(self, img, x, y):
        self.image = pygame.image.load(os.path.join('sprites', img))
        self.x = x
        self.y = y
        
    def jump(self):
        if self.y < height:
            self.y += 40
            
    def lower(self):
        if self.y > bottom:
            self.y -= 40