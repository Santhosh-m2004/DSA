"""Write a Python program to take a list and reverse the list and make a new list whose elements are equal to the sum of
 corresponding elements of the original list and the reversed list."""

lst1=list(map(int,input().split()))

def rev(lst1):
    rev_lst=lst1[::-1]
    new_lst=[]
    for i in range(len(lst1)):
        new_lst.append(lst1[i]+rev_lst[i])

    return new_lst

print(*rev(lst1),sep=",")