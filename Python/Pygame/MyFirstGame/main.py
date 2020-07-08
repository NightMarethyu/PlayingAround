import os, pygame, pygame_gui

from spriteClasses import Background
from gameplayClasses import Level

def main():
    pygame.init()
    
    # Set up the window
    pygame.display.set_caption('My First Game')
    screen = pygame.display.set_mode((800, 600))
    
    # Add a default gray background
    background = Background('1-1.png')
    
    level = Level(1, '1-1.png', 0, 0, 4)
    
    # Start the GUI manager
    manager = pygame_gui.UIManager((800, 600))
    clock = pygame.time.Clock()
    
    is_running = True
    
    while is_running:
        time_delta = clock.tick(60)/1000.0
        
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                is_running = False
                
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_RIGHT:
                    level.x_change = level.speed
            
            if event.type == pygame.KEYUP:
                if event.key == pygame.K_RIGHT:
                    level.x_change = 0
            
            manager.process_events(event)

        manager.update(time_delta)
        
        level.scroll_background()
        screen.blit(level.background, (level.x, level.y))
        
        manager.draw_ui(screen)
        
        pygame.display.update()
    
if __name__ == '__main__': main()