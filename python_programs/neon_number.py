"""Write a Python Program to check whether the accepted number is a
 Neonnumberornot.
 A number is said to be Neon number if the sum of the digits of
 the square of the number is equal to the number itself.
 If the number is a Neon number print True, otherwise print False
 Sample Input : 9
 Sample Output : True
 Explanation : 9^2=81
 8+1=9   """
 
n=int(input())
 
sqr1=int(n)*int(n)
sqr=str(sqr1)   #integer cannot be indexed so convert it into a string
sum1=0
for i in sqr:
    sum1+=int(i)
    
if(n==sum1):
    print("neon")
else:
    print("not neon")