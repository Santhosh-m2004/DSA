st_point=int(input())
count=10
def prime(st_point,count):
    list1=[]
    num=st_point
    
    while(len(list1)<count):
        is_prime=True
        for i in range(2,num):
            if(num%i==0):
                is_prime=False
                break
        
        if is_prime and num>1:
            list1.append(num)
        num+=1

    print(*list1)

prime(st_point,count)