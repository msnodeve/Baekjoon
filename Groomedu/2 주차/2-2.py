# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

# 최소 최대 값 구하기
min_val = sys.maxsize
max_val = -sys.maxsize-1
graph = {}

tree_deep = int(input())

def find(deep, lr, val):
	global min_val
	global max_val
	if deep >= tree_deep:
		min_val = min(min_val, val)
		max_val = max(max_val, val)
		return
	find(deep+1, lr*2, val+graph[deep][lr])
	find(deep+1, lr*2+1, val+graph[deep][lr])

for i in range(tree_deep):
	line = list(input())
	line = [ord(x)-64 for x in line]
	graph[i] = line

find(0, 0, 0)
print(min_val)
print(max_val)
	
	