#파일을 읽기방법
f=open('movies_v2.csv','r')

#for문 이해하기
for line in f:

    print (line)

    #하나의 라인을 항목으로 split()하기
    #split(), split(',') 옵션을 구별하기
    #strip() 함수가 있는 경우와 없는 경우 이해하기 
    line_list = line.strip().split(',')
    print (line_list)

    #개별 항목을 변수에 할당하기
    #Indexing List data structure
    num = line_list[0]
    name = line_list[1]
    age = line_list[2]
    movie = line_list[3]
    comment = line_list[4]
    year = line_list[5]

    #한줄을 읽을 때마다 insert 문을 만들기
    #https://wikidocs.net/13 의 "문자열포맷팅" 부분을 참고로 공부해도 좋음
    sql_01=  "insert into movies_2 values (%s, '%s', %s, '%s', '%s', %s)" %(num,name,age,movie,comment,year)

    #인서트문이 제대로 만들어졌는지 확인하기 (check the completion of "Insert statement")
    print ("<INSERT SQL:>", sql_01)

f.close()

