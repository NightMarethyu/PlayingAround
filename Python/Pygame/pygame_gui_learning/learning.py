import pygame
import pygame_gui

# quite a bit of this is basic set up code for a pygame instance
# There's the init(), creating the display, adding the listener
# for clicking exit, etc.
pygame.init()

pygame.display.set_caption('Quick Start')
window_surface = pygame.display.set_mode((800, 600))

background = pygame.Surface((800, 600))
background.fill(pygame.Color('#000000'))

# this is the first bit of pygame_gui code. You need a manager
# that is the size of the window for pygame_gui to work.
manager = pygame_gui.UIManager((800, 600))

# Now time to add something to the Gui, we'll start with a button
hello_button = pygame_gui.elements.UIButton(relative_rect=pygame.Rect((350, 275), (100, 50)),
                                            text='Dis Button',
                                            manager=manager)

clock = pygame.time.Clock()
is_running = True

while is_running:
    # the gui relies on the pygame clock to some extent so 
    # the tutorial has us add that here.
    time_delta = clock.tick(60)/1000.0
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            is_running = False
        
        # this is the event listener for clicking the UI button
        if event.type == pygame.USEREVENT:
            if event.user_type == pygame_gui.UI_BUTTON_PRESSED:
                if event.ui_element == hello_button:
                    print('Dis Printed Text')
                    
        # this will allow the gui to have access to the events that
        # occur in this loop    
        manager.process_events(event)
        
    manager.update(time_delta)
            
    window_surface.blit(background, (0, 0))
    
    # Now we need to add the gui to the display
    manager.draw_ui(window_surface)
    
    pygame.display.update()