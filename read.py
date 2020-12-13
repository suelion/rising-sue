
file = open("sue.txt", "r", encoding = "utf-8")

inStr = file.read()

inStr = inStr.replace(',', '')
inStr = inStr.replace('.', '')
inStr = inStr.replace('?', '')
inStr = inStr.replace('!', '')
inStr = inStr.replace('\"', '')
inStr = inStr.replace('\'', '')
inStr = inStr.replace('\t', '')
inStr = inStr.replace('\n', '')



lst = inStr.split(' ')


dic = dict()

for word in lst :
    if dic.get(word) is None :
        dic[word] = 1
    else :
        dic[word] += 1
print(dic)
