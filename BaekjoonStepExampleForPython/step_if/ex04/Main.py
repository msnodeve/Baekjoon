cntSub = int(input())
jumsu = input().split(" ")
jumsu = [int (i) for i in jumsu]
jumsu.sort()
jumsu = [i/jumsu[cntSub-1]*100 for i in jumsu]
print('%.2f'%float(sum(jumsu)/cntSub))