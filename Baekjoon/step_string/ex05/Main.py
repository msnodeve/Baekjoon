N = int(input())
cnt = 0
for i in range(0, N):
        word = input()
        flag = False
        temp = word[0]
        list = []
        for j in range(0, len(word)):
                if word[j] not in list:
                        temp = word[j]
                        list.append(word[j])
                else:
                        if temp == word[j]:
                                pass
                        else:
                                flag = True
                                break
        if flag == False:
                cnt += 1
print(cnt)
