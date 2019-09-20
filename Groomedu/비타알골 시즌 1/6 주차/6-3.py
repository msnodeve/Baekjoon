# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import queue
import sys
import numpy as np

# 확인 해봐야 할 좌표 저장
q = queue.Queue()

# 상하좌우를 확인하기 위한 x,y 좌표
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# x, y 좌표와 해당 좌표에서의 마력을 초기화
visit = np.zeros((100, 100, 11))

# 가로, 세로, 마력을 입력
R, C, K = map(int, input().split())

# 마법사의 숲 크기를 dict로 초기화
sup = {}

# 걸린 시간초
second = 0

# 마법사의 숲을 라인별로 입력
for i in range(R):
	sup[i] = input()

# 제일 처음부터 시작할 좌표와 마력을 입력
q.put([0, 0, int(K/10)])
# 해당 마력으로 좌표를 방문했음을 표시
visit[0,0,int(K/10)] = 1

# 마법사의 숲의 범위를 넘어 섰는가에 따른 체크 함수
def checkSup(x, y):
	global R, C
	return x >= 0 and x < R and y >= 0 and y < C

while q.qsize() != 0:
	size = q.qsize()
	while size != 0:
		# queue에서 방문해야할 좌표를 받아옴
		X, Y, K = q.get()
		
		# 해당 x, y 좌표가 출구(R, C) 에 도착했을 경우 걸린 시간을 출력하고 종료
		if (X == (R - 1)) and (Y == (C - 1)):
			print(second)
			sys.exit(0)
			
		# 상하좌우 조사
		for i in range(4):
			n_x = X + dx[i]
			n_y = Y + dy[i]
			
			# 범위를 벗어 났거나, 해당 마력으로 이미 방문을 했다면 다음 진행
			if (checkSup(n_x, n_y) == False) or (visit[n_x][n_y][K] == 1):
				continue
				
			# 지나 갈 수 있는 곳일 경우
			if sup[n_x][n_y] == '0':
				visit[n_x][n_y][K] = 1
				q.put([n_x, n_y, K])
			# 지나 갈 수 없는 곳일 경우(나무일 경우), 마력이 있다면
			elif K > 0:
				n_nx = n_x + dx[i]
				n_ny = n_y + dy[i]
				# 마력 1(10/10)을 쓰고 간 경우 그리고 그곳이 방문한 경우라면 다음 진행
				if (checkSup(n_nx, n_ny) == False) or (visit[n_nx][n_ny][K - 1] == 1):
					continue
				# 그곳이 지나 갈 수 있는 곳일 경우
				if sup[n_nx][n_ny] == '0':
					visit[n_nx][n_ny][K-1] = 1
					q.put([n_nx, n_ny, K-1])
		size -= 1
	second += 1

# 모든 경우가 통과되지 않은 경우 -1 출력
print(-1)