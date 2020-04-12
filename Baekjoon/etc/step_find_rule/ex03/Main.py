import math
rst = []
T = int(input())

for i in range(0, T):
        temp = input().split(" ")
        temp = [int (i) for i in temp]
        d = temp[1]- temp[0]
        rst.append(int(math.sqrt(d-0.5)*2.0))

for i in rst:
        print(i)