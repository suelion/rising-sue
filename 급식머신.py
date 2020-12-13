Menulist={"짜장면":[4, "짜장면", "단무지", "양파", "춘장"], "라면":[4, "라면", "김치"], "피자":[4, "피자", "피클"],
          "치킨":[4, "치킨", "치킨무"], "삼겹살":[4, "삼겹살", "상추", "김치", "고추장"], "갈비탕":[4, "갈비탕", "깍두기", "김치"], "백반":[4, "밥", "국", "김치", "콩나물", "고등어구이"]}
Order_list=["짜장면", "짜장면", "피자", "치킨", "삼겹살", "갈비탕", "백반", "짜장면", "짜장면", "치킨",
            "갈비탕", "삼겹살", "백반", "라면", "피자", "치킨", "짜장면", "치킨", "갈비탕", "백반", ]

##함수 선언 부분##
def food_service_robot(menu, guest) :
    """
    :param menu:
    :param guest:
    :return:
    """
    if menu in Menulist:
        for i in range(len(Menulist[menu])):
            if i==0:
                if (Menulist[menu][i])+1 > 0:
                    pass
                else:
                    print(menu,"은(는) 모두 팔렸습니다. 다른 메뉴를 선택하여 주세요 ->")
                    break
            elif i==1:
                print(Menulist[menu][i],"을(를) 주메뉴 칸에 담습니다.")
            elif i==2:
                print(Menulist[menu][i],"을(를) 반찬1 칸에 담습니다.")
            elif i==3:
                print(Menulist[menu][i],"을(를) 반찬2 칸에 담습니다.")
            elif i==4:
                print(Menulist[menu][i],"을(를) 반찬3 칸에 담습니다.")
            elif i==5:
                print(Menulist[menu][i],"을(를) 반찬4 칸에 담습니다.")
        print()
        if (Menulist[menu][0])+1>0:
            print(guest+1,"번 고객님", menu,"이(가)(를) 준비되었습니다.")
            print("남은", menu,"은(는)", Menulist[menu][0],"인분 입니다.")
        print()
        print()

##메인 코드 부분##
for i in range(len(Order_list)):
    print(i+1,"번 고객님 어떤 음식을 드릴까요?")
    print(Order_list[i])
    Menulist[Order_list[i]][0] -= 1
    food_service_robot(Order_list[i], i)
    if (Menulist[Order_list[i]][0])+1 <= 0:
        print("그렇다면", i + 1, "번 고객님 어떤 음식을 드릴까요?")
        Order_list[i] = (str(input()))
        Menulist[Order_list[i]][0] -= 1
        food_service_robot(Order_list[i], i)