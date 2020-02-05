C = int(input())
result = []
for i in range(0, C):
    cnt=0
    jumsu = input().split(" ")
    jumsu = [int(i) for i in jumsu]
    result.append(0)
    for j in list(range(1,jumsu[0]+1)):
        result[i] += jumsu[j]
    result[i] /= jumsu[0]
    for j in list(range(1,jumsu[0]+1)):
        if result[i] < jumsu[j]:
            cnt+=1
    result[i] = cnt / jumsu[0] * 100
for i in list(range(C)):
    print('%.3f%%'%float(result[i]))
