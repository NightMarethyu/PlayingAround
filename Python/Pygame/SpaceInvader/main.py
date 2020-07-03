import pygame
import random

# initialize the pygame
# this line will always be in a pygame file to start the game
pygame.init()

# create the screen
# This will likely be in every game as well since you want to show something on screen
# screen is in pixels (Width, Height)
screen = pygame.display.set_mode((800, 600))

#Title and Icon
pygame.display.set_caption("Space Invaders")
icon = pygame.image.load('ufo.png')
pygame.display.set_icon(icon)

# Player Image
playerImg = pygame.image.load('player.png')
playerX = 370
playerY = 480
playerX_change = 0

# Enemy Image
enemyImg = pygame.image.load('enemy.png')
enemyX = random.randint(0, 736)
enemyY = random.randint(0, 150)
enemyX_change = 0.2
enemyY_change = 40

def player(x, y):
    # this method will draw the player icon
    screen.blit(playerImg, (x, y))

def enemy(x, y):
    screen.blit(enemyImg, (x, y))

# Game Loop
running = True
while running:
    # Screen fill is in RBG with Opacity
    # Pygame will draw things in layers starting at the top, so we want the background drawn first
    screen.fill((1, 50, 1))
    
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

        # if keystroke is pressed check whether its right or left
        if event.type == pygame.KEYDOWN:
            # print("a key has been pressed")
            if event.key == pygame.K_LEFT:
                # print("Left arrow is pressed")
                playerX_change = -0.3
            elif event.key == pygame.K_RIGHT:
                # print("Right arrow is pressed")
                playerX_change = 0.3
                
        if event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                # print("Keystroke released")
                playerX_change = 0
        
    enemyX += enemyX_change
    
    if enemyX <= 0 or enemyX >= 736:
        enemyX_change = -enemyX_change
        enemyY += enemyY_change
    
    playerX += playerX_change
    
    # This will prevent the player sprite from going off the screen
    if playerX <= 0:
        playerX = 0
    elif playerX >= 736:
        playerX = 736
    
        
    # here we are drawing the player
    player(playerX, playerY)
    # this will draw the enemy
    enemy(enemyX, enemyY)
    
    # This is another always present line because you want to update the screen
    pygame.display.update()