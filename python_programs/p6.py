"""you have been given an integer array A of size n.you need to print the number with the value closest to zero.
If there are no multiple elements,print the number with greater value"""

n = int(input())
list1 = list(map(int, input().split()))

def prg(list1):
    less = None
    for num in list1:
        if num >= 0 and (less is None or num < less):
            less = num
            if num == 0:  # If 0 is encountered, break the loop since it's the smallest positive number
                break
    if less is None:
        print("No non-negative elements found.")
    else:
        print(less)

prg(list1)



