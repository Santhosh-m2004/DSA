"""Anagrams
You are given a string. Write a Python program to print only the anagrams present in the string.
Anagram means words containing same letters.
For Ex. listen and silent are anagrams."""

list1=input().split()

def anagram(str1,str2):
    str1=sorted(str1.lower())
    str2=sorted(str2.lower())
    if(str1==str2):
        return True
    else:
        return False

list2=[]
for i in list1:
    for j in list1:
        if i!=j and anagram(i,j):
            if i not in list2:
                list2.append(i)
            if j not in list2:
                list2.append(j)
print(*list2)  



        

