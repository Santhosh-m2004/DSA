"""Write a python program to find the product of a list of numbers based on the following rules. If 5 is not present in the list, 
display the product of all the numbers. If one of the integers is 5, display the product of numbers to the right of 5 excluding 5 
and any subsequent 5's.
If there are no numbers to the right of 5, display -1."""



list1=list(map(int,input().split())) 


pro=1
if 5 not in list1:
    for i in list1:
        pro=pro*i
else:
    index1=list1.index(5)
    if(index1==len(list1)-1):
        pro=-1
        
    else:
        for i in list1[index1 + 1:]:
            if(i!=5):
                pro=pro*i
                
print(pro)
