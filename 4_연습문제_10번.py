import turtle

num1, num2, result = 0, 0, 0
swidth, sheight = 1000, 300
curX, curY = 0, 0


def binary(Bin, num):
    curX = swidth / 2
    for i in range(len(Bin) - 2):
        turtle.goto(curX, curY)
        if num & 1:
            turtle.color('red')
            turtle.turtlesize(2)
        else:
            turtle.color('blue')
            turtle.turtlesize(1)
        turtle.stamp()
        curX -= 50
        num >>= 1


if __name__ == "__main__":
    turtle.title('거북이로 두 숫자 비트 논리곱(&) 연산하기')
    turtle.shape('turtle')
    turtle.setup(width=swidth + 50, height=sheight + 50)
    turtle.screensize(swidth, sheight)
    turtle.penup()
    turtle.left(90)

    num1 = int(input("숫자1을 입력하세요 : "))
    num2 = int(input("숫자2을 입력하세요 : "))
    binary1 = bin(num1)
    binary2 = bin(num2)
    result = num1 & num2

    curY = 50
    binary(bin(num1), num1)
    curY = 0
    binary(bin(num2), num2)
    curY = -50
    binary(bin(result), result)

turtle.done()