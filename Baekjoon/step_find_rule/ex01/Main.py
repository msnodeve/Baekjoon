N = int(input())
cnt = 0
result = 1
while(True):
    result += 6*cnt
    if result >= N:
        break
    cnt += 1
print(cnt+1)