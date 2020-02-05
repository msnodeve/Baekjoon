testCase = int(input())
list = []
for i in range(0, testCase):
        R = input().split(" ")
        for j in range(len(R[1])):
                list.append(R[1][j] * int(R[0]))
        list.append("-1")
for i in list:
        if i!="-1":
                print(i, end='')
        else:
                print("")