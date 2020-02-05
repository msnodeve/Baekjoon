rst = []

for i in range(0, 3):
        temp = input().split(" ")
        temp = [int(i) for i in temp]
        rst.append(temp.count(0))

for i in rst:
    if(i == 0):
        print("E")
    elif(i == 1):
        print("A")
    elif(i == 2):
        print("B")
    elif(i == 3):
        print("C")
    elif(i == 4):
        print("D")
