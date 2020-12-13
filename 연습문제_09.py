start_num = 0; end_num = 0

prime_num = True

sum = 0

start_num = int(input("*** 시작 숫자를 입력하세요(2이상) : "))
end_num = int(input("*** 끝 숫자를 입력하세요 : "))

for i in range(start_num, end_num+1, 1) :
    prime_num = True
    for j in range(2, i, 1) :
        if i % j == 0 :
            prime_num = False

    if prime_num == True :
        sum += i


print("%d 부터 %d까지 소수의 합은 %d입니다." %(start_num, end_num, sum))



