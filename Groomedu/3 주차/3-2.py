# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import queue
import sys

q = queue.Queue()
# 원준이 좌표
wj = {}

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
row, col = map(int, input().split())
# 방문
visit = [[0]*col for i in range(row)]

# 입력 받을 지도
wall = {}

for i in range(row):
	wall[i] = input()
	for j in range(col):
		# 원준이 위치
		if wall[i][j] == '&':
			wj = [i, j]
		# 불 위치 저장
		elif wall[i][j] == '@':
			visit[i][j] = 1
			q.put([i, j])
			
ans = 0
while q.qsize()!=0:
	qs = q.qsize()
	for i in range(qs):
		cur = q.get()
		
		if cur == wj:
			print(ans - 1)
			sys.exit(0)
		
		for i in range(4):
			x = cur[0] + dx[i]
			y = cur[1] + dy[i]
			
			if x < 0 or x >= row or y < 0 or y >= col or wall[x][y] == '#' or visit[x][y]:
				 continue
			visit[x][y] = 1
			q.put([x, y])
			 
	ans = ans + 1		 
print(-1)