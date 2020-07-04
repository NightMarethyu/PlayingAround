import pygame, random

from pygame import mixer

pygame.init()

class Player:
    speed = 4
    
    def __init__(self):
        self.img = pygame.image.load('sprites/player.png')
        self.x = 370
        self.y = 480
        self.x_change = 0
    
    def draw_player(self, screen):
        screen.blit(self.img, (self.x, self.y))
        
class Enemy:
    x_change = 3
    y_change = 40
    death = mixer.Sound('sounds/explosion.wav')
    
    def __init__(self):
        self.img = pygame.image.load('sprites/enemy.png')
        self.x = random.randint(0, 736)
        self.y = random.randint(0, 150)
    
    def draw_enemy(self, screen):
        screen.blit(self.img, (self.x, self.y))
        
class Bullet:
    y_change = 10
    sound = mixer.Sound('sounds/laser.wav')
    
    def __init__(self, x):
        self.img = pygame.image.load('sprites/bullet.png')
        self.x = x
        self.y = 490
        self.sound.play()
        
    def draw_bullet(self, screen):
        screen.blit(self.img, (self.x, self.y))