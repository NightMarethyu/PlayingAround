import os, pygame, pygame_gui

import settings

from gameStateClasses import Pause_game
from spriteClasses import Player

class Level():
    
    # Adding the level number and background as variables
    def __init__(self, lvl, bkgd, x, y, speed, screen, clock, manager):
        self.background = pygame.image.load(os.path.join('backgrounds', bkgd)).convert()
        self.length = self.background.get_rect().size
        self.levelCount = lvl
        self.x = x
        self.y = y
        self.speed = speed
        self.x_change = 0
        self.play_level(screen, clock, manager)
        
    def scroll_background(self, screen):
        self.x -= self.x_change
        if self.x <= -(self.length[0] - 800):
            self.x = -(self.length[0] - 800)
        screen.blit(self.background, (self.x, self.y))
            
    def play_level(self, screen, clock, manager):
        while settings.playing:
            time_delta = clock.tick(60)/1000.0
        
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    settings.playing = False
                    
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_ESCAPE:
                        pause = Pause_game(screen, clock, manager)
                    if event.key == pygame.K_RIGHT:
                        self.x_change = self.speed
                    
                if event.type == pygame.KEYUP:
                    if event.key == pygame.K_RIGHT:
                        self.x_change = 0
                
                manager.process_events(event)
            
            manager.update(time_delta)
            
            self.scroll_background(screen)
            
            manager.draw_ui(screen)
            pygame.display.update()
            