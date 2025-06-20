""" Write a Python program to check whether a given number is Spy
 number or not.
 A number is said to be a Spy number if the sum of all the dig
its is equal to the product of all digits.
 For Ex. 1412 is a Spy number
 Bacause,
 Product of all digits = 1 * 4 * 1 * 2 = 8
 Sumofall digits = 1+4+1+2 = 8  """
 
 
n = input().strip() 

def sum1(n):
    sum2 = 0
    for i in n:
        sum2 += int(i)  # Convert each string element to integer and sum them up
        
    return sum2
    
def pro(n):
    pro2=1
    for i in n:
        pro2=pro2*int(i)
        
    return pro2
    
if(sum1(n)==pro(n)):
    print("spy")
    
else:
    print("not spy")



        