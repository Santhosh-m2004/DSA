num=int(input())
list1=[input() for i in range(num)]

def palin(list1):
    new_list=[]
    for item in list1:
        if item==item[::-1]:
            new_list.append(item)

    return new_list
print(*palin(list1),sep="\n")
