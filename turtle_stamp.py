"""import turtle
import random

##함수 선언 부분##

def stamp(x, y) :
    global r, g, b
    turtle.color((r, g, b))
    r = random.random()
    g = random.random()
    b = random.random()

    tSize = random.randrange(1, 10)
    turtle.shapesize(tSize)

    tAngle = random.randrange(0, 360)
    turtle.right(tAngle)

    turtle.stamp()


def screenMidClick(x, y) :
    turtle.penup()
    turtle.goto(x, y)


##변수 선언 부분##
r, g, b = 0.0, 0.0, 0.0

##메인 코드 부분##
turtle.title('거북이 도장 찍기')
turtle.shape('turtle')


turtle.onscreenclick(screenMidClick, 2)
turtle.onscreenclick(stamp, 1)


turtle.done()
"""

import turtle
import random
def screenLeftClick(x, y):
    global r, g, b
    turtle.color(r, g, b)
    turtle.penup()
    turtle.goto(x, y)
    turtle.stamp()
    tSize = random.randrange(1, 10)
    turtle.shapesize(tSize)
    tAngle = random.randrange(0, 360)
    turtle.left(tAngle)
    r = random.random()
    g = random.random()
    b = random.random()

pSize = 10
r, g, b = 0.0, 0.0, 0.0
turtle.title('turtle draw')
turtle.shape('turtle')
turtle.onscreenclick(screenLeftClick, 1)
turtle.done()