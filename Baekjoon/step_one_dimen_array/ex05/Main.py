list = []
for i in range(0,5):
        temp = int(input())
        if temp <= 40:
                list.append(40)
        else:
                list.append(temp)
print(int(sum(list)/5))