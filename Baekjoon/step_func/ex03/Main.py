import math
N = int(input())
base = ["  *   ", " * *  ", "***** "]
k = int(math.log(N/3, 2))
for i in range(k):
    for j in range(len(base)):
        base.append(base[j] + base[j])
        base[j] = ("   " * pow(2,i) + base[j] + "   " * pow(2,i))
for i in base:
    print(i)