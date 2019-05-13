list = []
for i in range(0,26):
        list.append(0)
word = input().lower()
for i in range(0, len(word)):
        list[ord(word[i])-97]+=1
if list.count(max(list)) != 1:
        print("?")
else:
        print(chr(97+list.index(max(list))).upper())