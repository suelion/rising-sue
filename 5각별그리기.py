import turtle as t
import math
from math import *

R = int(input("반경을 입력하시오 : "))

"""X1 = 0
Y1 = R

X2 = R*cos(pi/10)
Y2 = R*sin(pi/10)

X3 = -(R*cos(pi/10))
Y3 = R*sin(pi/10)

X4 = R*cos((3/10)*pi)
Y4 = -(R*sin((3/10)*pi))

X5 = -(R*cos((3/10)*pi))
Y5 = -(R*sin((3/10)*pi))"""

x = [R*cos((3/10)*pi), -(R*cos(pi/10)), R*cos(pi/10), -(R*cos((3/10)*pi)), 0]
y = [-(R*sin((3/10)*pi)), R*sin(pi/10), R*sin(pi/10), -(R*sin((3/10)*pi)), R]

t.title('별 그리기')
t.shape('classic')
t.pensize(5)
t.pencolor('black')


"""t.penup()
t.setpos(X1, Y1)

t.pendown()
t.goto(X4, Y4)

t.goto(X3, Y3)

t.goto(X2, Y2)

t.goto(X5, Y5)

t.goto(X1, Y1)"""

t.penup()
t.setpos(x[4], y[4])

t.pendown()
for i in range(5):
    t.goto(x[i], y[i])


t.done()