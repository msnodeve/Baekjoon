
# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import re
import sys
# 12가 나오고 21이 나오는 경우
one_two_reg = re.compile('.*12.*21.*')
two_one_reg = re.compile('.*21.*12.*')

user_input = input()

if re.match(one_two_reg, user_input):
	print("Yes")
else:
	if re.match(two_one_reg, user_input):
		print("Yes")
		sys.exit(0)
	print("No")
