A=int(input())
B=int(input())
C=int(input())
list =[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
result = A*B*C
while(result!=0):
        list[result % 10] += 1
        result = int(result/10)
for i in list:
        print(i)