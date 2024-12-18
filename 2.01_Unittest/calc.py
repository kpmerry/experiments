def add(a, b):
    if type(a) != int or type(b) != int:
        raise TypeError
    return a + b


def multiply(a, b):
    if type(a) != int or type(b) != int:
        raise TypeError
    return a * b


def divide(a, b):
    if type(a) != int or type(b) != int:
        raise TypeError
    if b == 0:
        raise ZeroDivisionError
    return a / b


def subtract(a, b):
    if type(a) != int or type(b) != int:
        raise TypeError
    return int(a - b)


def area_triangle(a, b):
    if type(a) != int or type(b) != int:
        raise TypeError
    return (a * b) / 2


def area_circle():
    pass
