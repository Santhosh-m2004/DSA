"""python prg that takes a list of integers and removes duplicates and print only the unique numbers present in the given list.
skip the numbers divisible by 3.arrange the output in ascending order"""

n=int(input())
list1=[]
for i in range(n):
    list1.append(int(input()))

def prg(list1):
    unique=set()

    for i in list1:
        if(i%3!=0):
            unique.add(i)

    unique=sorted(unique)

    print(*unique)

prg(list1)
