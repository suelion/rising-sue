height = int(input("다이아몬드의 높이 입력 : "))
# height는 높이(세로)
widht = int(input("다이아몬드의 폭 입력 : "))
# widht는 폭(가로)


# 중심으로부터 직선전까지 좌표 찍힘. 반대로 뒤집어서 빼면, 공백이 생김.
def draw_diamond(h, w):
    if ((h % 2 ==0) and (w % 2 ==0)) or ((h % 2 ==0) and (w % 2 == 1)) :
        for i in range(1, int(h / 2)+1, 1) :
            print((" " * (int((w / 2)-((w / h)*i))) )+(("*") * int((w / h) * (2*i +1) )))

        for j in range(int(h / 2), 0, -1) :
            print((" " * (int((w / 2)-((w / h)*j))) )+(("*") * int((w / h) * (2*j +1) )))


    else :
        for i in range(1, int(h / 2) + 1, 1):
            print((" " * (int((w / 2) - ((w / h) * i) + 1))) + (("*") * int((w / h) * (2 * i - 1))))
        print("*" * w)

        for j in range(int(h / 2)-1, -1, -1) :
            print((" " * (int((w / 2)-((w / h)*j))) )+(("*") * int((w / h) * (2*j +1) )))


if __name__ == '__main__':

    draw_diamond(height, widht)




"""
def diamond(width, height):
    """
"""Diamond 를 그리는 함수.
    :param width:  다이아몬드의 폭
    :param height:  다이아몬드의 높이
    :return:
    """
"""
    num_half_lines = height//2
    is_odd = height%2           # 홀수이면 1, 짝수이면 0
    incremental_num_star = (width-1)/(num_half_lines)
    num_star = 1
    # 위의 반쪽을 그린다
    for i in range(num_half_lines):
        num_space = int(width-num_star+0.5)     # 가장 가까운 정수를 구하기 위하여 반올림 효과를 준다.
        num_space_front = int(num_space/2)      # 앞쪽의 빈칸 갯수
        num_space_rear = num_space - num_space_front # 뒤쪽의 빈칸 갯수
        for j in range(num_space_front):
            print(" ",end = '')
        for j in range(int(num_star+0.5)):
            print("*",end = '')
        for j in range(num_space_rear):
            print(" ",end = '')
        print("i=",i, num_star, "\r")   # Debug 을 위하여 line number 와 Star 의 갯수릂 표기함.
        num_star = num_star+incremental_num_star
    # 높이가 홀수인 경우 가장 폭이 넓은 가운데 Line 을 그린다
    if is_odd:
        for j in range(width):
            print('*',end='')
        print("\r")

    num_star = num_star - incremental_num_star
    # 아래 반쪽을 그린다.
    for i in range(num_half_lines):
        num_space = int(width-num_star+0.5)
        num_space_front = int(num_space/2)
        num_space_rear = num_space - num_space_front
        for j in range(num_space_front):
            print(" ",end = '')
        for j in range(int(num_star+0.5)):
            print("*",end = '')
        for j in range(num_space_rear):
            print(" ",end = '')
        print("i=",i, num_star, "\r") # Debug 을 위하여 line number 와 Star 의 갯수릂 표기함.
        num_star = num_star-incremental_num_star

if __name__ == "__main__":
    width = int(input("넓이 = "))
    height = int(input("높이 = "))
    diamond(width, height)

"""
    
