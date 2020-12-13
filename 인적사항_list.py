person = [["홍길동", 20, "남", "서울"], ["성춘향", 20, "여", "전북"], ["이몽룡", 30, "남","서울"], ["이상", 30, "남", "서울"], ["문재인", 67, "남", "부산"]]

def get_age():
    while True :
        try :
            age = int(input("나이"))
            return age
        except :
            print("나이는 양의 정수로 입력하세요")

def get_sex() :
    while True :
        sex = input("성별")
        if sex == "남" or sex == "여" :
            return
        else :
            print("성별은 남/여로 입력하세요")

if __name__ == '__main__':
    while True :
        print("---메뉴를 선택하세요")
        print("1 : 새로운 인명 등록")
        print("2 : 인명 검색 및 인적사항 출력")
        print("3 : 인명 검색 및 인적사항 수정")
        print("4 : 나이별 인원수 출력")
        print("5 : 출생지별 인적사항 출력")
        print("6 : 인적사항 삭제")
        print("7 : 종료")
        menu = input()
        
        if menu == '1' :
            new = [0, 0, 0, 0]
            new[0] = input("이름")
            new[1] = get_age()
            new[2] = get_sex()
            new[3] = input("출생지 ")
            person.append(new)
            print(person)
            
        elif menu == '2' :
            name = input("이름")
            num_person_same_name = 0
            num_person = len(person)
            for i in range(num_person) :
                if (name == person[i][0]) :
                    print(person[i])
                    num_person_same_name += 1
            if(num_person_same_name == 0) :
                    print(name, " 은 없습니다")
            elif num_person_same_name >= 2 :
                    print(name, "이", num_person_same_name, "명 있습니다.")

        elif menu == '3' :
            name = input("이름")
            num_person_same_name = 0
            num_person = len(person)
            for i in range(num_person) :
                if (name == person[i][0]) :
                    print(i, person[i])
                    num_person_same_name += 1
                    person_id = i
            if num_person_same_name >= 2 :
                print(name, "이", num_person_same_name, "명 있습니다.")
                person_id = int(input("번호로 선택하세요 "))
                while True :
                    person_id = int(input("번호로 선택하세요"))
                    if person[person_id][0] == name :
                        break
                    else :
                        print("잘못 선택하였습니다.")
                        pass
            else :
                pass
            if num_person_same_name >= 1 :
                menu_modify = input("수정할 항목을 선택하세요 이름 -1, 나이 -2, 성별 -2, 출생지 -4, 나가기 -5")
                if menu_modify == '1' :
                    person[person_id][0] = input("이름")
                elif menu_modify == '2' :
                    person[person_id][1] = get_age()
                elif menu_modify == '3':
                    person[person_id][2] = get_sex()
                elif menu_modify == '4' :
                    person[person_id][3] = input("출생지")
                else :
                    pass
                print(person[person_id], "로 수정되었습니다.")
            else :
                print(name, "은 없습니다.")

        elif menu == '4' :
            num_person = len(person)
            age_list = []
            for i in range(num_person) :
                age_list.append(person[i][1])
            age_list.sort()
            print(age_list)
            age_former = age_list[0]
            age_density = [[age_list[0], 1]]
            print(age_density)
            list_pointer = 0
            for i in age_list[1:] :
                print("age=", i, "pointer", list_pointer)
                if i == age_former :
                    age_density[list_pointer][1] += 1
                else :
                    age_former = i
                    list_pointer += 1
                    age_density.append([i, 1])
                print("연령별 인원수", age_density)

        elif menu == '5' :
            num_person = len(person)
            birthplace_list = []
            for i in range(num_person) :
                birthplace_list.append(person[i][3])
            birthplace_list.sort()
            print(birthplace_list)
            birthplace_former = birthplace_list[0]
            birthplace_density = [[birthplace_list[0], 1]]
            print(birthplace_density)
            list_pointer = 0
            for i in birthplace_former :
                print("birthplace =", i, "pointer", list_pointer)
                if i == birthplace_former :
                    birthplace_density[list_pointer][1] += 1
                else :
                    birthplace_former = i
                    list_pointer += 1
                    birthplace_density.append([i, 1])
                print("출생지별 인원수", birthplace_density)

        elif menu == '6' :
            num_person = len(person)
            name = input("삭제할 이름을 입력하세요")
            i = 0
            for i in range(num_person) :
                print(person[i], "을 삭제할까요? (Y/N)")
                sel = input()

                if sel == 'Y' or sel == 'y' :
                    person[i][0] = 'No_name'
            print(person)

        elif menu == '7' :
            exit()



"""
import copy
from collections import OrderedDict

data1 = OrderedDict(); data2 = OrderedDict()

info_list = True
num = 0; name =''; age = 0 ;gender = ''; birthPlace = ''

#data2 = [["홍길동", 20, "남", "서울"], ["성춘향", 21, "여", "전북"], ["이몽룡", 23, "남", "서울"]]

while info_list :
    print("1. 새로운 인명 등록\t")
    print("2. 인명 검색 및 인적사항 출력\t")
    print("3. 인명 검색 후 인적사항 수정\t")
    print("4. 나이별의 인원 수 출력\t")
    print("5. 출생지별 인적사항 출력\t")
    print("6 인적사항 삭제\t")
    print("7. 프로그램 종료")

    num = int(input("원하는 메뉴(숫자)를 선택하세요 : "))

    if num == 1 :
        name = input("이름을 입력하세요 :")
        age = input("나이를 입력하세요 :")
        gender = input("성별을 입력하세요 (여 / 남) : ")
        birthPlace = input("출생지를 입력하세요 : ")
        data2["이름"] = name; data2["나이"] = age; data2["성별"] = gender; data2["출생지"] = birthPlace;
        data1[name] = copy.deepcopy(data2)
        data1[age] = copy.deepcopy(data2)
        data1[birthPlace] = copy.deepcopy(data2)

        data2.clear()
        print("새로운 인명이 등록 완료 되었습니다.")

    elif num == 2 :
        name = input("검색을 원하는 인명의 이름을 입력하세요 : ")

        if data1.get(name) == None :
            print("해당 인명은 리스트에 존재하지 않습니다.")
        else :
            for i, k in data1[name].items() :
                print(i, ":", k)

    elif num == 3 :
        name = input("수정을 원하는 사람의 이름을 입력하세요 : ")

        if data1.get(name) == None :
            print("해당 사람은 리스트에 존재하지 않습니다.")
        else :
            for i, k in data1[name].items() :
                print(i, ":", k)
            correct = input("수정할 인적사항 항목을 입력하세요 (이름 / 나이 / 성별 / 출생지) : ")

            if correct == '이름' :
                change = input("수정할 이름 : ")
                data1[name][correct] = change
                print("인적사항이 수정 완료 되었습니다.")
            elif correct == '나이' :
                change = input("수정할 나이 : ")
                data1[name][correct] = change
                print("인적사항이 수정 완료 되었습니다.")
            elif correct == '성별':
                change = input("수정할 성별 : ")
                data1[name][correct] = change
                print("인적사항이 수정 완료 되었습니다.")
            elif correct == '출생지':
                change = input("수정할 출생지 : ")
                data1[name][correct] = change
                print("인적사항이 수정 완료 되었습니다.")
            else :
                print("수정할 수 없습니다.")

    elif num == 4 :
        age = int(input("나이별 인원 수를 보기 위해 원하는 나이를 입력하세요 : "))

        if data1.get(age) == None :
            print("해당 나이는 리스트에 존재하지 않습니다.")
        else :
            print(data1[age].count())

    elif num == 5 :
        birthPlace = input("출생지별 인적 사항을 보기 위하여 원하는 출생지를 입력하세요 : ")

        if data1.get(birthPlace) == None :
            print("해당 출생지는 리스트에 존재하지 않습니다.")
        else :
            if 'birthPlace' in data1[birthPlace] :
                for i, k in data1[birthPlace].items():
                    print(i, ":", k)

    elif num == 6 :
        name = input("삭제를 원하는 사람의 이름을 입력하세요 : ")
        if data1.get(name) == None :
            print("해당 사람은 리스트에 존재하지 않습니다.")
        else :
            data1.pop(name)
            print("%s 는 리스트에서 삭제되었습니다." %name)

    elif num == 7 :
        print("프로그램을 종료합니다.")
        info_list = False






"""


