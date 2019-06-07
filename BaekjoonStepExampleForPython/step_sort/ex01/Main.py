T = int(input())        # 테스트 케이스
li = []                 # 넣을 값
for i in range(0, T):
        li.append(int(input()))
li = list(set(li))
li.sort()
for i in li:
        print(i)