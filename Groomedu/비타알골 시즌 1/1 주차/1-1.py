# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

# 모음
vowels = 'aeiouAEIOU'

# 결과 값을 출력할 리스트
result = []
# 사용자 입력 숫자
lineNum = int(input())

# 입력 받은 수 만큼 원하는 문구 입력
for i in range(0, lineNum):
	# temp 값 초기화
	temp = ''
	# 입력 받은 라인만큼
	for letters in input():
		# 모음 이 포함되어 있다면, 모음 뽑아 내기
		if letters in vowels:
			temp += letters
	# 뽑아낸 모음들을 result 리스트에 저장
	result.append(temp)
	
for i in result:
	if i:
		print(i)
	else:
		print('???')