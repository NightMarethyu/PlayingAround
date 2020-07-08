import os, pygame, pygame_gui

class Level():
    
    # Adding the level number and background as variables
    def __init__(self, lvl, bkgd, x, y, speed):
        self.background = pygame.image.load(os.path.join('backgrounds', bkgd)).convert()
        self.length = self.background.get_rect().size
        self.levelCount = lvl
        self.x = x
        self.y = y
        self.speed = speed
        self.x_change = 0
        
    def draw_background(self, screen):
        screen.blit(self.background, (self.x, self.y))
        
    def scroll_background(self):
        self.x -= self.x_change
        if self.x <= -(self.length[0] - 800):
            self.x = -(self.length[0] - 800)