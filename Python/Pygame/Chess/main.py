import os, pygame, pygame_gui

import settings

pygame.init()

def main():
    settings.init()
    
    pygame.init()
    
    pygame.display.set_caption('Chess')
    screen = pygame.display.set_mode((800, 600))
    clock = pygame.time.clock()
    
    while settings.playing:
        time_delta = clock.tick(60)/1000.0
        
        for event in pygame.event.get():
            if event.type == pygame.quit:
                settings.playing = False

if __name__ == '__main__':
    main()