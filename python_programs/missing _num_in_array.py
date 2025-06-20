list1=list(map(int,input().split(',')))

start=list1[0]
end=list1[-1]
for i in range(start,end):
    if i not in list1:
        print(i)
