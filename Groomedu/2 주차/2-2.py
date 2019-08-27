# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

# 최소 최대 값 구하기
min_val = 0
max_val = 0

tree_deep = int(input())
for i in range(tree_deep):
	line = list(input())
	line = [ord(x)-64 for x in line]
	line = sorted(line)
	min_val += line[0]
	max_val += line[len(line)-1]
	
print(min_val)
print(max_val)
