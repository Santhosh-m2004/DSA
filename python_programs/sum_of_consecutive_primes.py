"""Some prime numbers are equal to the sum of other consecutive
 prime numbers.
 For example 5 = 2 + 3, 17 = 2 + 3 + 5 + 7, 41 = 2 + 3 + 5 + 7 + 11
 + 13.
 Write a python program to find out the prime numbers that sat
isfy this property up to a given number.
 Sample Input : 50
 Sample Output :
 5
 17
 41    """
 
 
n=int(input())
def isprime(n):
    if n<2:
        return False
    elif n==2:
        return True
    else:
        for i in range(2,n):
            if(n%i==0):
                return False
            
        return True
        
list1=[]

for i in range(2,n+1):
    if isprime(i):
        list1.append(i)



for i in range(1,len(list1)):
    sum1=0 
    for k in list1[0:i]:
        sum1=sum1+k 
        if sum1==list1[i]:
            print(list1[i])
            break
    
        