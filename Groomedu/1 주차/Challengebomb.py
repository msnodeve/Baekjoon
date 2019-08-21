# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
from operator import itemgetter
import sys
# 개수 입력
user_input = int(input())
lst = []
for i in range(0, user_input):
	scale = input().split(" ")
	lst.append(scale)
	
monthList = []
for i in range(0, user_input):
	start1 = int(lst[i][0].split("/")[0])
	start2 = int(lst[i][0].split("/")[1])
	end1 = int(lst[i][1].split("/")[0])
	end2 = int(lst[i][1].split("/")[1])
	monthList.append([start1 * 100 + start2, end1 * 100 + end2])

# 1번째 인자 오름차순 정리, 2번째 인자 내림차순 정리
monthList = sorted(monthList, key = lambda x : (x[0], -x[1]))

stack = []
stack.append(monthList[0])

for i in range(0, len(monthList)):
	if stack[len(stack)-1][1] > monthList[i][0]:
		stack.append(monthList[i])
	else:
		while True:
			if stack[len(stack)-1][1] < monthList[i][0]:
				stack.pop()
				if len(stack) == 0:
					print("No")
					sys.exit(0)
			else:
				print("No")
				sys.exit(0)
		
print("Yes")
