N = int(input())
n1 = 0
n2 = 0
cnt = 0
if N < 10:
    n1 = 0
    n2 = N
else:    
    n1 = int(N / 10)
    n2 = N % 10
while(True):
    sum = n1 + n2
    cnt += 1
    if (n2*10) + (sum%10) == N:
        break
    else:
        n1 = n2
        n2 = sum%10
print(cnt)