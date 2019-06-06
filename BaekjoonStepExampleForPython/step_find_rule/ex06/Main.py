from sys import stdin
from math import ceil

n = list(stdin.readline())
li = [n.count(str(x)) for x in range(0, 10)]
t = int(ceil((li.pop(9) + li.pop(6))/2))
print(t if t>max(li) else max(li))