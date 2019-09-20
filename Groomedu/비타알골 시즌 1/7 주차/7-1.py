# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
user_input = int(input())

lst = []
result = []

for i in range(user_input):
	a, b = map(float, input().split())
	lst.append([a, b])

def ccw(a, b, c):
	ret = a[0] * b[1] + b[0] * c[1] + c[0] * a[1]
	ret -= a[1] * b[0] + b[1] * c[0] + c[1] * a[0]
	if ret > 0:
		return 1
	elif ret < 0:
		return -1
	return 0
	
for i in range(2, user_input):
	d = ccw(lst[i-2], lst[i-1], lst[i])
	if d > 0:
		result.append("LEFT")
	else:
		result.append("RIGHT")
		
for i in result:
	print(i)