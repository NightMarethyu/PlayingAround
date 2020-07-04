import math, pygame

from pygame import mixer

from gameClasses import Player, Enemy, Bullet
from helpers import checkCollision

pygame.init()

running = True
screen = pygame.display.set_mode((800, 600))

background = pygame.image.load('sprites/background.png')

score = 0

score_font = pygame.font.Font('ARCADECLASSIC.TTF', 32)
over_font = pygame.font.Font('ARCADECLASSIC.TTF', 64)

pygame.display.set_caption("Space Invaders")
icon = pygame.image.load('sprites/ufo.png')
pygame.display.set_icon(icon)

character = Player()
bullets = []
num_of_enemies = 6

enemies = []

for i in range(num_of_enemies):
    enemies.append(Enemy())

def game_over():
    over_text = over_font.render("GAME OVER", True, (255, 0, 0))
    screen.blit(over_text, (200, 250))

def show_score():
    score_text = score_font.render("Score   " + str(score), True, (255, 255, 0))
    screen.blit(score_text, (10, 10))

while running:
    # screen.fill(0, 0, 0)
    screen.blit(background, (0, 0))
    
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                character.x_change = -(character.speed)
            elif event.key == pygame.K_RIGHT:
                character.x_change = character.speed
            elif event.key == pygame.K_SPACE:
                bullets.append(Bullet((character.x + 10)))
        
        if event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
                character.x_change = 0
    
    for bullet in bullets:
        if bullet.y <= 0:
            bullets.remove(bullet)
        else:
            bullet.draw_bullet(screen)
            bullet.y -= bullet.y_change
    
    for enemy in enemies:
        for bullet in bullets:
            if checkCollision(enemy.x, enemy.y, bullet.x, bullet.y):
                bullets.remove(bullet)
                score += 1
                enemy.death.play()
                enemies.remove(enemy)
                enemies.append(Enemy())
        
        enemy.x += enemy.x_change
        
        if enemy.y > 440:
            enemies.clear()
            game_over()
            pygame.display.update()
            break
        
        if enemy.x <= 0 or enemy.x >= 736:
            enemy.x_change = -(enemy.x_change)
            enemy.y += enemy.y_change
            
        enemy.draw_enemy(screen)
    
    character.x += character.x_change
    if character.x <= 0:
        character.x = 0
    elif character.x >= 736:
        character.x = 736
    
    character.draw_player(screen)
    
    show_score()
    
    pygame.display.update()