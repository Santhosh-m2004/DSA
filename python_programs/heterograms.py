"""Heterograms
Write a Python program to check whether a given string is Heterogramor not. Return True if the given
string is a Heterogram. Otherwise, return False.
A heterogram is a word, phrase, or sentence in which no letter of the alphabet occurs more than once.
For ex. ‘the big dwarf only jumps"""

str1=input()
str1=str1.replace(" ","")
str2=set(str1)
if(len(str1)==len(str2)):
    print(True)
else:
    print(False)
