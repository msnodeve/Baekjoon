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
# print(monthList)
stack = []
flag = True
compare=monthList[0];
for i in range(1, len(monthList)):
	# 경우 1, 이전 마감보다 새로운 시작이 같거나 크면 통과
	if compare[1] <= monthList[i][0]:
		compare = monthList[i]
		continue
	# 경우 2, 이전 마감보다 새로운 시작이 작은경우
	else:
		# 이전 마감과 새로운 마감이 같은 경우
		if compare[1] == monthList[i][1]:
			compare = monthList[i]
		# 이전 마감보다 새로운 마감이 작은 경우
		elif compare[1] > monthList[i][1]:
			stack.append(compare)
			compare = monthList[i]
		else:
			if len(stack) != 0:
				for j in stack:
					if j[1] < monthList[i][1]:
						print("No")
						sys.exit(0)

if flag:
	print("Yes")
else:
	print("No")
