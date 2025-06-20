""" Some prime numbers are equal to the sum of other consecutive
 prime numbers.
 For example 5 = 2 + 3, 17 = 2 + 3 + 5 + 7, 41 = 2 + 3 + 5 + 7 + 11
 + 13.
 Write a python program to find out the prime numbers that sat
isfy this property up to a given number.
 Sample Input : 50
 Sample Output :
 5
 17
 41"""
 
 
def isprime(num):
    if num<2:
        return False
    elif num==2:
        return True
    else:
        for i in range(2,num):
            if num%i==0:
                return False
        return True
        

n=int(input())
list1=[]
for i in range(n):
    if isprime(i):
        list1.append(i)
        
print(list1)

for i in range(1,len(list1)):
    sum1=0 
    for k in list1[0:i]:
        sum1=sum1+k 
        if sum1==list1[i]:
            print(list1[i])
            break
        
        
