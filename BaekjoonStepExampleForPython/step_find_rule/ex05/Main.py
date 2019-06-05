apt = [[1]*15 for i in range(15)]
rst = []

for i in range(15):
        apt[0][i] = i+1

for i in range(1, 15):
        for j in range(1, 15):
                apt[i][j] = apt[i-1][j] + apt[i][j-1]

T = int(input())

for i in range(0, T):
        w = int(input())
        h = int(input())
        rst.append(apt[w][h-1])

for i in rst:
        print(i)
