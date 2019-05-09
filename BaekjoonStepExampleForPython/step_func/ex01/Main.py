list = []
result = []
def sum_digit(number):  # n + 각자리 n 합 함수
    return number + sum([int(i) for i in str(number)])

for i in range(1, 10000):
    temp = i
    cnt = 0
    if i not in list:
        result.append(i)
        while(True):
            temp = sum_digit(temp)
            if temp not in list:
                list.append(temp)
            if temp > 10000:
                break

for i in result:
    print(i)
