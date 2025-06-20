n1=int(input())
n2=int(input())

def prime(n1,n2):
    list1=[]
    for num in range(n1,n2+1):
        is_prime=True
        for i in range(2,num):
            if(num%i==0):
                is_prime=False
                break

        if is_prime and num>1:
            list1.append(num)
        
    print(*list1)   

prime(n1,n2)