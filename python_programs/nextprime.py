""" Write a Python program to generate N prime numbers starting from
 the given number.
 Sample Input :
 10
 5
 Input Description : First number gives the starting point. Sec
ond numbergives how manyprimenumbers to generate.
 Sample Output :
 [11, 13, 17, 19, 23]"""
 
def prime(n):
    for i in range(2,n):
        if n%i==0:
            return False
    return True
        

st=int(input())
no=int(input())

count=0 
list1=[]

while(count<no):
    if prime(st):
        list1.append(st)
        count+=1
    st=st+1
    
print(list1)