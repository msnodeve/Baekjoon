list = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
str = input()
cnt = 0
for i in range(len(list)):
        if list[i] in str:
                cnt += str.count(list[i])
                str = str.replace(list[i]," ")
str = str.replace(" ","")
cnt += len(str)
print(cnt)