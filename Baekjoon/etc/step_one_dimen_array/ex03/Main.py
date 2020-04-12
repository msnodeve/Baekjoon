textCase = int(input())
score = []
for i in range(0, textCase):
        cnt = 0
        addCount = 1
        quiz = input()
        for j in range(0, len(quiz)):
                if quiz[j] == "O":
                        cnt += addCount
                        addCount += 1
                else:
                        addCount = 1
        score.append(cnt)
for i in score:
        print(i)