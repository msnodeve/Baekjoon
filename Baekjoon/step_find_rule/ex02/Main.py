N = int(input())
step = 0
cnt = 1
flag = True
while(True):
    if N <= step+cnt:
        break
    step += cnt
    flag = not flag
    cnt += 1
if flag:
    print(cnt-(N-step-1), end="")
    print("/", end="")
    print(1+(N-step-1))
else:
    print(1+(N-step-1), end="")
    print("/", end="")
    print(cnt-(N-step-1))
