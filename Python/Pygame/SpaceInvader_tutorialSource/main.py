import math, pygame, random

from pygame import mixer

# initialize the pygame
# this line will always be in a pygame file to start the game
pygame.init()

# create the screen
# This will likely be in every game as well since you want to show something on screen
# screen is in pixels (Width, Height)
screen = pygame.display.set_mode((800, 600))

# Background
background = pygame.image.load('background.png')

# Background Sound
mixer.music.load('background.wav')
mixer.music.play(-1)

#Title and Icon
pygame.display.set_caption("Space Invaders")
icon = pygame.image.load('ufo.png')
pygame.display.set_icon(icon)

# Player Image
playerImg = pygame.image.load('player.png')
playerX = 370
playerY = 480
playerX_change = 0

# Score
score_value = 0
font = pygame.font.Font('freesansbold.ttf', 32)

textX = 10
textY = 10

# Game Over Text
over_font = pygame.font.Font('freesansbold.ttf', 64)

# Enemy Image
enemyImg = []
enemyX = []
enemyY = []
enemyX_change = []
enemyY_change = 40
num_of_enemies = 6

for i in range(num_of_enemies):
    enemyImg.append(pygame.image.load('enemy.png'))
    enemyX.append(random.randint(0, 736))
    enemyY.append(random.randint(0, 150))
    enemyX_change.append(3)

# Bullet Sprite
bulletImg = pygame.image.load('bullet.png')
bulletX = 0
bulletY = 480
bulletY_change = 10
bullet_state = "ready"

def player(x, y):
    # this method will draw the player icon
    screen.blit(playerImg, (x, y))

def enemy(x, y, i):
    screen.blit(enemyImg[i], (x, y))

def fire_bullet(x, y):
    global bullet_state
    bullet_state = "fire"
    screen.blit(bulletImg, (x + 16, y + 10))

def isCollision(enemyX, enemyY, bulletX, bulletY):
    distance = math.sqrt(math.pow((enemyX - bulletX), 2) + math.pow((enemyY - bulletY), 2))
    if distance <= 27:
        return True
    else:
        return False

def show_score(x, y):
    score = font.render("Score: " + str(score_value), True, (255, 255, 0))
    screen.blit(score, (x, y))
    
def game_over_text(x, y):
    over_text = over_font.render("GAME OVER", True, (255, 0, 0))
    screen.blit(over_text, (x, y))

# Game Loop
running = True
while running:
    # Screen fill is in RBG with Opacity
    # Pygame will draw things in layers starting at the top, so we want the background drawn first
    screen.fill((0, 0, 0))
    # background image
    screen.blit(background, (0, 0))
    
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

        # if keystroke is pressed check whether its right or left
        if event.type == pygame.KEYDOWN:
            # print("a key has been pressed")
            if event.key == pygame.K_LEFT:
                # print("Left arrow is pressed")
                playerX_change = -4
            elif event.key == pygame.K_RIGHT:
                # print("Right arrow is pressed")
                playerX_change = 4
            elif event.key == pygame.K_SPACE:
                if bullet_state == "ready":
                    bullet_sound = mixer.Sound('laser.wav')
                    bullet_sound.play()
                    bulletX = playerX
                    fire_bullet(bulletX, bulletY)
                
        if event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                # print("Keystroke released")
                playerX_change = 0
    
    # bullet Movement
    if bulletY <= 0:
        bulletY = 480
        bullet_state = "ready"
        
    if bullet_state == "fire":
        fire_bullet(bulletX, bulletY)
        bulletY -= bulletY_change
    
    for i in range(num_of_enemies):
        # Collision
        if isCollision(enemyX[i], enemyY[i], bulletX, bulletY):
            bulletY = 480
            bullet_state = "ready"
            score_value += 1
            explosion_sound = mixer.Sound('explosion.wav')
            explosion_sound.play()
            enemyX[i] = random.randint(0, 736)
            enemyY[i] = random.randint(0, 150)
        
        enemyX[i] += enemyX_change[i]
        
        # Game Over
        if enemyY[i] > 440:
            for j in range(num_of_enemies):
                enemyY[j] = 2000
            game_over_text(200, 250)
            break
        
        if enemyX[i] <= 0 or enemyX[i] >= 736:
            enemyX_change[i] = -enemyX_change[i]
            enemyY[i] += enemyY_change
    
    playerX += playerX_change
    
    # This will prevent the player sprite from going off the screen
    if playerX <= 0:
        playerX = 0
    elif playerX >= 736:
        playerX = 736
    
        
    # here we are drawing the player
    player(playerX, playerY)
    # this will draw the enemy
    for i in range(num_of_enemies):
        enemy(enemyX[i], enemyY[i], i)
    
    show_score(textX, textY)
    
    # This is another always present line because you want to update the screen
    pygame.display.update()