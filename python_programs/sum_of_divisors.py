#write a program to determie a numner N is equal to the sum of its proper positive divisors
n=int(input())
list1=[]
for i in range(n):
    list1.append(int(input()))

def per(list1):
    for num in list1:
        divisor_sum=0
        for i in range(1,num):
            if(num%i==0):
                divisor_sum=divisor_sum+i
        return divisor_sum==num
    
for num in list1:
    if per([num]):
        print("Yes")
    else:
        print("No")


