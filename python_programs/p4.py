"""python prg for print the odd factors of a number"""

n=int(input())

def prg(n):
    odd_factors=[]

    for i in range(1,n+1):
        if(n%i==0 and i%2!=0):
            odd_factors.append(i)

    print(*odd_factors)


prg(n)
