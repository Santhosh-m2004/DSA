"""Two people made a list of movies they like and dislike. Write a Python program to find the number
of movies they both like and the number of movies they both dislike.
Input Description: Input1 and Input2 are strings containing 1s and 0s. 1s represent likes and 0s
represent dislikes."""

str1=input()
str2=input()

like_count=0
dislike_count=0
for i in range(max(len(str1),len(str2))):
    if str1[i]=='0' and str2[i]=='0':
        dislike_count+=1
    elif str1[i]=='1' and str2[i]=='1':
        like_count+=1

print(like_count,dislike_count,sep=",") 