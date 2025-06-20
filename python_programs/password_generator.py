n=int(input())
list1=[]
for i in range(n):
    list1.append(input())

def prg(list1):
    list2=[]
    low_count=0
    up_count=0
    digit_count=0
    sp_count=0
    spl_count=0
    spl='!@#$%^&*'
    
    
    for word in list1:
        for i in word:
            if(i.islower()):
                low_count+=1
            elif(i.isupper()):
                up_count+=1
            elif(i.isdigit()):
                digit_count+=1
            elif(i.isspace()):
                sp_count+=1
            elif(i in spl):
                spl_count+=1

        if(len(word)>=8) and (len(word)<=16 and up_count>=2 and low_count>=2 and digit_count>=1 and sp_count==0 and spl_count>=1):
            list2.append(word)
        
    if(len(list2)==0):
        print("Nil")
    else:
        print(*list2,sep="\n")

prg(list1)