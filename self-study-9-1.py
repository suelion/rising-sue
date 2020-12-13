##전역 변수 선언 부분##
coffee = 0

##함수 선언 부분##
def coffee_machine(button) :
    """

    :param button:
    :return:
    """
    print()
    print("#1. (자동으로) 뜨거운 물을 준비한다.");
    print("#2. (자동으로) 종이컵을 준비한다.");
    if button == 1 :
        coffee = "아메리카노"
    elif button == 2 :
        coffee = "카페라떼"
    elif button == 3 :
        coffee = "카푸치노"
    elif button == 4 :
        coffee = "에스프레소"
    print("#3. (자동으로) ", coffee, "를 탄다")

    print("#4. (자동으로) 물을 붓는다.");
    print("#5. (자동으로) 스푼으로 젓는다.");
    print()

##메인 코드 부분##
coffee = int(input("로제씨, 어떤 커피 드릴까요?(1:아메리카노, 2:카페라떼, 3:카푸치노, 4:에스프레소"))
coffee_machine(coffee)
print("로제씨~ 커피여기 있습니다.")