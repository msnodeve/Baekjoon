N = int(input())
list = []
numCnt = 0

def eachDigit(num):
    list.clear()
    while(num != 0):
        list.append(num%10)
        num = int(num /10)
    list.reverse()

def confirm(lst):
    if len(lst) < 3:
        return 1
    else:
        if lst[2]-lst[1] == lst[1]-lst[0]:
            return 1
        else:
            return 0
        

for i in range(1, N+1):
    eachDigit(i)
    numCnt += confirm(list)

print(numCnt)

