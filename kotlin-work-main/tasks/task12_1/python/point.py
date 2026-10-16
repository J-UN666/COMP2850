# Task 12.1: Point class

from math import hypot


class Point:
    """A point in 2D space, with x and y coordinates."""

    def __init__(self, x=0.0, y=0.0):
        self.x = x
        self.y = y

    def distance(self):
        """The distance of this point from the origin."""
        return hypot(self.x, self.y)

    def distance_to(self, other):
        """The distance of this point from another point."""
        return hypot(self.x - other.x, self.y - other.y)

    def __str__(self):
        return f"({self.x}, {self.y})"
