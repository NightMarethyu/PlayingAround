import os, pygame, pygame_gui

import settings

from spriteClasses import Background
from gameplayClasses import Level
from gameStateClasses import Pause_game

def main():
    settings.init()
    
    pygame.init()
    
    # Set up the window
    pygame.display.set_caption('My First Game')
    screen = pygame.display.set_mode((800, 600))
    
    # Start the GUI manager
    manager = pygame_gui.UIManager((800, 600))
    clock = pygame.time.Clock()
    
    new_game = pygame_gui.elements.UIButton(relative_rect=pygame.Rect((350, 275), (100, 50)),
                                            text="New Game",
                                            manager=manager)
    
    while settings.playing:
        time_delta = clock.tick(60)/1000.0
        
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                settings.playing = False
                
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_ESCAPE:
                    pause = Pause_game(screen, clock, manager)
            
            if event.type == pygame.USEREVENT:
                if event.user_type == pygame_gui.UI_BUTTON_PRESSED:
                    if event.ui_element == new_game:
                        new_game.hide()
                        level = Level(1, '1-1.png', 0, 0, 4, screen, clock, manager)
                        
            manager.process_events(event)
        
        manager.update(time_delta)
        manager.draw_ui(screen)
        
        pygame.display.update()
    
if __name__ == '__main__': main()