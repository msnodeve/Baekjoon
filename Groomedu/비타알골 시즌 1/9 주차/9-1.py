# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

import bisect
import numpy as np

N = int(input())
arr = [int (i) for i in input().split(" ")]

lst = np.zeros(N)
l = 0
for i in range(N):
	pos = bisect.bisect_left(lst, arr[i], 0, l)
	lst[pos] = arr[i]
	if pos == l:
		l += 1
print(N-l)
