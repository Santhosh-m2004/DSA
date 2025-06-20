"""python program takes a list of numbers and prints only those numbers wich are not repeated .
if there are no non repeated number ,print"none" """

n=int(input())

list1=[]

for i in range (n):
    list1.append(int(input()))

def prg(num1):
    non_repeated=[]
    for i in num1:
        if num1.count(i)==1:
            non_repeated.append(i)
    
    if not non_repeated :
        print("None")
    else:
        print(*non_repeated)
prg(list1)