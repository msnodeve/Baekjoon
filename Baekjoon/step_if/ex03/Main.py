rst = []
lst = input().split(" ")
lst = [int (i) for i in lst]
num = input().split(" ")
num = [int (i) for i in num]
for i in num:
    if i < lst[1]:
        print(i, end=" ") 