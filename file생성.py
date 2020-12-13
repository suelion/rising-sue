outFp = None
outStr = ""
filename = input("file 명을 입력하세요")
newname = filename+".txt"
outFp = open(newname, "w")

while True :
    outStr = input("내용 입력 : ")
    if outStr != "" :
        outFp.writelines(outStr + "\n")
    else :
        break

outFp.close()
print("--- 파일에 정상적으로 서졌음 ---")