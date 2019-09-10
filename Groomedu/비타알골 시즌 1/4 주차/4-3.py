# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

max_val = -sys.maxsize-1

graph = {}

tree_deep = int(input())

def find(deep, val):
	global max_val
    import pdb; pdb.set_trace()
	if deep >= tree_deep:
		max_val = max(max_val, val)
		return
	for j in range(len(graph[deep]+1)):
		find(deep+1, val+graph[deep][j])

for i in range(tree_deep):
	line = list(input())
	line = [ord(x)-64 for x in line]
	graph[i] = line

# print(len(graph[3]))
# for i in range(tree_deep):
	
find(0,0)
print(max_val)