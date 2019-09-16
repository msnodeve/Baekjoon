# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import bisect
N = int(input())
listN = [int (i) for i in input().split(" ")]
listN.sort()
M = int(input())
listM = [int (i) for i in input().split(" ")]
result = []
for i in range(M):
	temp = bisect.bisect(listN, listM[i])
	if temp == 0:
		if listM[i] == listN[temp]:
			result.append(1)
		else:
			result.append(0)
	elif temp == len(listN):
		if listM[i] == listN[temp-1]:
			result.append(1)
		else:
			result.append(0)
	else:
		if listM[i] == listN[temp-1]:
			result.append(1)
		else:
			result.append(0)

for i in result:
	print(i)