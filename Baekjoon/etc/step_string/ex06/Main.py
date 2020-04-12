num = input().split(" ")
num = [int(i) for i in num]

def rever(temp):
        n1 = int(temp % 10)
        n2 = int(temp/10 % 10)
        n3 = int(temp/100)
        return n1*100 + n2*10 + n3

num[0] = rever(num[0])
num[1] = rever(num[1])
print(max(num))
