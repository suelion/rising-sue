import turtle
import random

##함수 선언 부분##
def screenLeftClick(x, y) :
    """

    :param x: x 좌표
    :param y: y 좌표
    :return:
    """

    global r, g, b
    turtle.pencolor((r, g, b))
    turtle.pendown()
    turtle.goto(x, y)

def screenRightClick(x, y) :
    """
    comment
    :param x:
    :param y:
    :return:
    """

    turtle.penup()
    turtle.goto(x, y)

def screenMidClick(x, y) :
    global r, g, b
    tSize = random.randrange(1, 10)
    turtle.shapesize(tSize)
    r = random.random()
    g = random.random()
    b = random.random()

##변수 선언 부분##
pSize=10
r, g, b = 0.0, 0.0, 0.0

##메인 코드 부분##
turtle.title('거북이로 그림 그리기')
turtle.shape('turtle')
turtle.pensize(pSize)

turtle.onscreenclick(screenLeftClick, 1)
turtle.onscreenclick(screenMidClick, 2)
turtle.onscreenclick(screenRightClick, 3)

print(screenLeftClick.__doc__)
print(turtle.done.__doc__)
print(turtle.shape.__doc__)

turtle.done()
