# Task 12.1: program that uses a Point object

from point import Point


def main():
    # A point built from the primary constructor
    p = Point(3.0, 4.0)
    print(f"p = {p}")
    print(f"Distance of p from the origin: {p.distance()}")

    # A point built from integer coordinates
    q = Point(4, 7)
    print(f"q = {q}")

    # A point built from the default (no-argument) constructor
    origin = Point()
    print(f"origin = {origin}")

    # The distance between two points
    print(f"Distance between p and q: {p.distance_to(q)}")

    # The attributes are mutable, so a point can be moved
    p.x = 0.0
    p.y = 5.0
    print(f"After moving p: {p}")
    print(f"Distance of p from the origin: {p.distance()}")


if __name__ == "__main__":
    main()
