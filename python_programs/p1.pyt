"""write a python program which take an integer as input and forms a new number which has the least significant digit of the
 original number in it's one's place and total number of digits of the original number in its ten's place"""

num=int(input("Enter a number :"))

def program(num):
    lsn=num%10

    m=len(str(num))
    new_num=lsn+m*10
    return new_num

ori_num=program(num)

print("New number is ",ori_num)