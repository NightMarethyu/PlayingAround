import os, pygame

class Background():
    def __init__(self, img):
        self.image = pygame.image.load(os.path.join('tempAssets', img)).convert()