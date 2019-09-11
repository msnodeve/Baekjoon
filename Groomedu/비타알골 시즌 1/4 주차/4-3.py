# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

max_val = -sys.maxsize-1

graph = {}

tree_deep = int(input())

for i in range(tree_deep):
	line = list(input())
	line = [ord(x)-64 for x in line]
	graph[i] = line

ref = graph
for i in range(1, tree_deep):
	for j in range(0, i+1):
		if(j == 0):
			ref[i][j] += graph[i-1][j]
		elif(i == j):
			ref[i][j] += graph[i-1][j-1]
		else:
			ref[i][j] += max(graph[i-1][j-1], graph[i-1][j])
	
print(max(ref[tree_deep-1]))