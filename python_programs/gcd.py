a=int(input())
b=int(input())

def gcd(num1,num2):
    while num2!=0:
        num1,num2=num2,num1%num2
    print("",num1)

gcd(a,b)