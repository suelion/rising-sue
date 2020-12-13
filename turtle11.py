import turtle

r = int(input("반경 : "))
n = int(input("변의 수 : "))

turtle.title('정다각형그리기')
for i in range(n):
    turtle.fd(r)
    turtle.right(360/n)

turtle.done()



"""
Import turtle
Import random
Import math
Radius = float(input(“외접원의 반경을 입력하세요 : “))
Num_edge = int(input(“변의 개수를 입력하세요 : “))
Point = []
Del_angle = 2*math.pi/num_edge
For I in range(num_edge)
	Ang = del_angle*i
	Point.append([radius*math.cos(ang), radius*math.sin(ang)])

pSize = 10
r, g, b = 0.0, 0.0, 0.0

turtle.title(‘turtle draw’)
turtle.shape(3)
turtle.setup(width = 400, height = 400)
turtle.screensize(400, 400)

turtle.penup()
turtle.goto(point[0][0], point[0][1])
tuetle.pendown()
for I in range(1, num_edge+1, 1) :
	ipoint = i%num_dedge
	turtle.goto(point[ipoint][0], point[ipoint[1]]

tuetle.done()

"""
