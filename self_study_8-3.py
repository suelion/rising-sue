while True:
    ss = input("문자열을 입력하세요")
    print(ss, "는")
    if ss.isalpha():
        print("글자입니다.\n")
    elif ss.isdigit():
        print("숫자입니다\n")
    elif ss.isalnum():
        print("글자 + 숫자 입니다\n") #isdigit 과 isalnum의 순서 주의하자.

    else:
        print("모르겠습니다.")