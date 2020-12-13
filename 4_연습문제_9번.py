money, c1, c2, c3, c4, c5, c6, c7, c8 = [0] * 9

money=int(input("교환할 돈은 얼마? "))

c1 = money // 50000
money %= 50000

c2 = money // 10000
money %= 10000

c3 = money // 5000
money %= 5000

c4 = money // 1000
money %= 1000

c5 = money // 500
money %= 500

c6 = money // 100
money %= 100

c7 = money // 50
money %= 50

c8 = money // 10
money %= 10

print(" 50000원 %d장, 10000원 %d장, 5000원 %d장, 1000원 %d장" % (c1,c2,c3,c4))
print(" 500원 %d개, 100원 %d개, 50원 %d개, 10원 %d개" % (c5,c6,c7,c8))
print(" 바꾸지 못한 돈 ==> %d원"% money)