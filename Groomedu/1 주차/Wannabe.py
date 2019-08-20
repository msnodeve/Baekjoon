# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import math

# 해당 수의 약수 중에 제일 최소 값
def divisor(num):
	sqrtNum = int(math.sqrt(num))
	cnt = 2
	while cnt <= sqrtNum:
		if num % cnt == 0:
			return cnt
		cnt += 1
	return num

# 입력 값 두 개
inputNum = input().split(" ")
inputNum = [int(i) for i in inputNum]


if inputNum[0] == inputNum[1]:
    # 두 값이 같으면 작은 수에서의 약수 값 구하기
	print(divisor(inputNum[0]))
else:
    # 그렇지 않을 경우 무조건 2 약수 반환
	print(2)
