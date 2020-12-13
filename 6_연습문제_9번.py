import turtle
import random

swidth, sheight = 500,500
pSize = 5
r, g, b = [0] * 3
angle, dist = 30, 5

turtle.title("거북 소라 그리기")
turtle.shape('turtle')
turtle.pensize(pSize)
turtle.setup(width = swidth + 50, height = sheight + 50)
turtle.screensize(swidth, sheight)

for i in range(80):
    r = random.random()
    g = random.random()
    b = random.random()
    turtle.pencolor((r,g,b))

    dist += 1
    turtle.forward(dist)
    turtle.left(angle)

turtle.done()