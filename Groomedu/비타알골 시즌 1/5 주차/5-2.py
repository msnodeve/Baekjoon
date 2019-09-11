# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

N = int(input())

stack = []
val = 1
count = 0
def cmd(c):
	global stack
	global count
	global val
	if c[0] == "add":
		stack.append(int(c[1]))
	else:
		if len(stack) != 0 and stack[len(stack)-1] == val:
			stack.pop()
		elif len(stack) != 0:
			count += 1
			while len(stack) !=0 :
				stack.pop()
		val += 1
		
for i in range(0, 2*N):
	command = input().split()
	cmd(command)
print(count)