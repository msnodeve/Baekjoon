rst = []
T = int(input())

for i in range(0, T):
        temp = input().split(" ")
        temp = [int (i) for i in temp]
        if temp[2]%temp[0] == 0:
                rst.append(temp[0]*100+int(((temp[2]-1)/temp[0])+1))
        else:
                rst.append((temp[2]%temp[0])*100+int(((temp[2]-1)/temp[0])+1))

for i in rst:
        print(i)
