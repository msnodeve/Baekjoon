list = [[3, 'A', 'B', 'C'], [4, 'D', 'E', 'F'], [5, 'G', 'H', 'I'], [6, 'J', 'K', 'L'], [7, 'M', 'N', 'O'], [8, 'P', 'Q', 'R', 'S'], [9, 'T', 'U', 'V'], [10, 'W', 'X', 'Y', 'Z']]
line = input()
cnt = 0
for i in range(len(list)):
        for j in range(len(line)):
                if line[j] in list[i]:
                        cnt += list[i][0]
print(cnt)