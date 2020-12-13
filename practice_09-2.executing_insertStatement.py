########################################################################
import MySQLdb
db = MySQLdb.connect(host="localhost",    # your host, usually localhost
                     user="root",         # your username
                     passwd="autoset",  # your password
                     db="bigdata",    # name of the data base
                     charset="utf8")         
cursor = db.cursor()
#아래 줄이 반드시 있어야 함
cursor.execute("SET names utf8")
########################################################################


#파일을 읽기방법
f=open('movies_v2.csv','r')

#for문 이해하기
for line in f:
    print (line)
    line_list = line.strip().split(',')
    print (line_list)

    num = line_list[0]
    name = line_list[1]
    age = line_list[2]
    movie = line_list[3]
    comment = line_list[4]
    year = line_list[5]

    #새로운 빈 테이블을 만들어 인서트하기(테이블 복사)
    sql_01=  "insert into movies_2 values (%s, '%s', %s, '%s', '%s', %s)" %(num,name,age,movie,comment,year)
    print (sql_01)

    ########################################################################
    #실제 인서트 실행하기
    cursor.execute(sql_01)
    ########################################################################


#매우 중요. commit()의 의미를 알아둘 것.
#인서트 작업이 모두 끝난 후 한번에 적용함(transaction의 개념임)
#MySQL(MariaDB)의 엔진타입 중 InnoDB에 적용가능.

####################### 두 엔진의 장단점 비교 #######################################
#InnoDB는 변경작업(insert, update, delete)의 속도가 빠름. commit, roll-back 지원
#MyISAM 엔진은 commit을 지원하지 않음. 단순하고 select 작업속도가 빨라 읽기에 적합)
####################################################################################
db.commit()

cursor.close()
f.close()

