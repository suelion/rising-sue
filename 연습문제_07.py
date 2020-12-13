import random

A = random.randrange(1, 7)
B = random.randrange(1, 7)

print("A의 주사위 숫자는 %d입니다." %A)
print("B의 주사위 숫자는 %d입니다." %B)

if (A > B) :
    print("A가 이겼습니다.")
elif (A < B) :
    print("B가 이겼습니다.")
else :
    print("비겼습니다.")


'''
import random
dice1, dice2 = 0, 0

dice1 = random.randrange(0,7)
print("A의 주사위 숫자는 %d입니다." % dice1)
dice2 = random.randrange(0,7)
print("B의 주사위 숫자는 %d입니다." % dice2)

if dice1 == dice2:
	print("비겼습니다.")
elif dice1 > dice2:
	print("A가 이겼습니다.")
else :
	print("B가 이겼습니다.")
'''