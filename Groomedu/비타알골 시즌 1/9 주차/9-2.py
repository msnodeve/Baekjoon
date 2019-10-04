# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean


def check_broken(ram_count, ram_list):
	rst_count = 0
	rst = []
	for item_num in range(ram_count):
		check_binary = ram_list[item_num] and not(ram_list[item_num] & (ram_list[item_num] - 1))
		if check_binary == False:
			rst_count += 1
			rst.append(item_num + 1)
	return rst_count, rst

def solution(rst):
	if rst[0] == 0:
		print(0)
	else:
		print(rst[0])
		for i in rst[1]:
			print(i, end = " ")
			
ram_count = int(input())
ram_list = [int (i) for i in input().split(" ")]

solution(check_broken(ram_count, ram_list))