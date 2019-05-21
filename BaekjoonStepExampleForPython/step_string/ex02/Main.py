S = input()
list = []
for i in range(0, 26):
    list.append(-1)
for i in range(0, len(S)):
    if list[ord(S[i])-97] == -1:
        list[ord(S[i])-97] = i
for i in list:
    print(i, end=' ')