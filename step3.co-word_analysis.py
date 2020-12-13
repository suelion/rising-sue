import MySQLdb
import math

db = MySQLdb.connect(host="localhost", user="root", passwd="autoset", db="bigdata", charset="utf8")
cursor = db.cursor()

cursor.execute("SET names utf8")

#######################################
## You are conducting CO-WORD ANALYSIS !
#######################################
#http://www.abcya.com/word_clouds.htm
#https://www.wordclouds.com/
#############################

#user-defined search term
query = "소녀시대"



fw = open(query+".txt",'w')

sql_01 = "select distinct cn from naver_news_term where term ='%s'" %query

print (sql_01)

cursor.execute(sql_01)


#term_list to contain all co-words
term_list=[]

for row in cursor.fetchall():
    #row[0] is CN realated to the given query term
    cn = row[0]
    
    #getting  co-occurred terms (= co-words) from the table
    
    sql_02= "select term from naver_news_term where cn =%d" %cn
    print (sql_02)


    #nested 2-dimensional structure of FOR statement
    cursor.execute(sql_02)

    for row in cursor.fetchall():
        coword = row[0]
        #print (coword)

        term_list.append(coword)


   
#filtering low frequent terms
#SET functoin to return unique items from the list
term_list_final=[]

for unique_term in set(term_list):

    freq = term_list.count(unique_term)

    #use LOG fuction to analyze well
    #로그함수의 특성을 이해 : 멱함수 법칙
    freq = int(math.log(freq,8))
    
    
    #print unique_term, freq

    for cnt in range(0,freq):
        #print (cnt)
        term_list_final.append(unique_term)


#concatenate all word in the list with separator " "
final_coword =" ".join(term_list_final)

print (final_coword)#, len(term_list), len(term_list_final)

fw.write(final_coword)


db.close()
fw.close()
