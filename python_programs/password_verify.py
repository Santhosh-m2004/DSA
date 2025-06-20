def prg(usn):
    return(len(usn)==10 and usn[0].isdigit() and usn[1:2].isalpha() and usn[3:4].isdigit() and usn[5:6].isalpha() and usn[7:9].isdigit())

n=int(input())
usns=[]
for i in range(n):
    usn=input()
    if prg(usn):
        usns.append(usn)
print(usns)