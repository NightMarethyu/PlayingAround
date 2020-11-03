import os, pygame, pygame_gui

import settings

class Pause_game:
    def __init__(self, screen, clock, manager):
        #pygame.init()
        
        play_button = pygame_gui.elements.UIButton(relative_rect=pygame.Rect((350, 275), (100, 50)),
                                                   text='Resume', manager=manager)
        
        paused = True
        
        while paused and playing:
            time_delta = clock.tick(60)/1000.0
        
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    playing = False

                if event.type == pygame.USEREVENT:
                    if event.user_type == pygame_gui.UI_BUTTON_PRESSED:
                        if event.ui_element == play_button:
                            play_button.kill()
                            paused = False
            
                manager.process_events(event)
            
            manager.update(time_delta)
            
            manager.draw_ui(screen)
            
            pygame.display.update()


class Main_menu:
    def __init__(self, screen, clock, manager):
        # TODO
        self.screen = screen