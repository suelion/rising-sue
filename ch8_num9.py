import turtle
import random
import math
from tkinter.simpledialog import *

##전역 변수 선언 부분##
inStr = ''
swidth, sheight = 300, 300
tX, tY, txtSize = 0, 0, 20
radius, angle, radian = 100, 0, 0

##메인 코드 부분##
turtle.title('거북이 반시계방향으로 원 그리며 글자 쓰기')
turtle.shape('turtle')
turtle.setup(width = swidth + 50, height = sheight + 50)
turtle.screensize(swidth, sheight)
turtle.penup()

inStr = askstring('문자열 입력', '거북이 쓸 문자열을 입력')

angle = 360 / len(inStr) #360도에서 문자열의 개수만큼 나누어 각도를 회전시키면서 글자를 쓴다.
for ch in inStr :
    radian = 3.14 * angle / 180

    tX = radius * math.cos(radian) #X좌표 = 거리*COS(각도)
    tY = radius * math.sin(radian) #Y좌표 = 거리*SIN(각도)
    r = random.random(); g = random.random(); b = random.random()

    turtle.goto(tX, tY)

    turtle.pencolor((r, g, b))
    turtle.write(ch, font=('맑은 고딕', txtSize, 'bold'))

    angle += 360 / len(inStr) #각도만큼 반시계로 회전한다.

turtle.done()