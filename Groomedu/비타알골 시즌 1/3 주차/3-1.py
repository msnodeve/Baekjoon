# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

# 살아온 날짜, 궁금해 하는 날짜 구간의 개수
N, M = map(int, input().split())

money = [int (i) for i in input().split(" ")]

lst = []
result = []
for i in range(0, N+1):
	if i == 0:
		lst.append(0)
	else :
		lst.append(lst[i-1] + money[i-1])

for i in range(M):
	a, b = map(int, input().split())
	result.append(lst[b] - lst[a-1])

for i in result:
	print('{:+d}'.format(i))
