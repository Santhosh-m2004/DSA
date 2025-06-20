"""Write a Python program to check whether a given number is Krish
namurthy number or not.
 Print True if the number is Krishnamurthy number, else print False
 
 A Krishnamurthy number is a number which is equal to the sum of
 the factorial of its digits
 For example, 145 = 1! + 4! + 5!     """

n=int(input())

def fact(n):
    if(n==0 or n==1):
        return 1
    else:
        return n*fact(n-1)
    
def krishna(n):
    str_n=str(n)
    sum1=0
    for digit in str_n:
        digit_fact=fact(int(digit))
        sum1+=digit_fact

    return sum1==n

if(krishna(n)):
    print("yes")
else:
    print("no")