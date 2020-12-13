import turtle
import random

myTurtle, tX, tY, tColor, tSize, tShape, tSum = [None] *7
playerTurtles = []
swidth, sheight = 500, 500

# main
if __name__ == '__main__':

    turtle.title('리스트 정렬해서 거북이 선으로 잇기')
    turtle.setup(width = swidth + 50, height = sheight + 50)
    turtle.screensize(swidth, sheight)

    for i in range(0, 10) :
        myTurtle = turtle.Turtle('turtle')
        tX = random.randrange(-swidth / 2, swidth / 2)
        tY = random.randrange(-sheight / 2, sheight / 2)
        r =random.random(); g =random.random(); b =random.random()
        tSize =random.randrange(1, 3)
        tSum = tX + tY
        playerTurtles.append([myTurtle, tX, tY, tSize, r, g, b, tSum])

    sortedTurtles = sorted(playerTurtles, key=lambda turtles: turtles[7], reverse = True)
    # lambda 는 런타임에 생성해서 사용할 수 있는 익명 함수, 쓰고 버리는 일시적인 함수

    # enumerate는 “열거하다”라는 뜻이다, 리스트가 있는 경우 순서와 리스트의 값을 전달하는 기능을 가진다.
    # 이 함수는 순서가 있는 자료형(list, set, tuple, dictionary, string)을 입력으로 받아 인덱스 값을 포함하는 enumerate 객체를 리턴한다.
    # 보통 enumerate 함수는 for문과 함께 자주 사용된다.
    for index, tList in enumerate(sortedTurtles[0:]):
        myTurtle = tList[0]
        myTurtle.color((tList[4], tList[5], tList[6]))
        myTurtle.pencolor((tList[4], tList[5], tList[6]))
        myTurtle.turtlesize(tList[3])
        myTurtle.penup()

        if index == 0:
            myTurtle.goto(tList[1], tList[2])
            continue

        myTurtle.goto(sortedTurtles[index - 1][1], sortedTurtles[index - 1][2])

        myTurtle.pendown()
        myTurtle.goto(tList[1], tList[2])

turtle.done()