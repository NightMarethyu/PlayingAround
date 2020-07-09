import os, pygame

import settings

class Platform:
    def __init__(self, screen, clock, manager, x, y, rectangle):
        self.rectangle = pygame.Rect((rectangle), (x, y))