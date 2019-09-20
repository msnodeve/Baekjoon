# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys
import math

N, M = map(int, input().split())

h = [int (i) for i in input().split(" ")]
max_val = max(h)
sum_val = sum(h)

if max_val * N - sum_val > M:
	print("No way!")
	sys.exit(0)

	
s = max_val
e = 2000000000

while s <= e:
	mid = e - (e -s) / 2
	l = 0
	
	for i in range(N):
		l += int(mid) - h[i]
	
	if l > M:
		e = int(mid) -1
	else:
		s = int(mid) +1
		
print(e)