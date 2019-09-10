# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

# 음수 아닐 경우
max_val = 0

user_input = int(input())

# 입력 값 받아서 정수형으로 변환
nums = [int (i) for i in input().split(" ")]

# 현재까지 저장해놓은 값들
plan = []

for i in range(0, user_input):
	if i == 0:
		# 0번째 일 때 일단 plan에 넣고
		# 만약 음수라면 마지막에 max_val이랑 비교해서 max_val만
		plan.append(nums[i])
	else:
		# 1번째 부터는 지금 부터가 더 큰지
		# 이전꺼에 지금 것을 더한게 큰지를
		# plan에 넣음
		plan.append(max(nums[i], plan[i-1] + nums[i]))
	# 지금까지 해온게 더 큰지 아니면 이전 최대 값이 더 큰지 확인
	max_val = max(max_val, plan[i])

print(max_val)