
user_input = input("문자열 입력 : ")

cnt = 1
temp_str = user_input[0]
for i in range(1 ,len(user_input)):
    if temp_str == user_input[i]:
        cnt += 1
    else:
        if cnt == 1:
            print(temp_str, end="")
        else:
            print(temp_str+str(cnt), end="")
        temp_str = user_input[i]
        cnt = 1
    if i == len(user_input)-1:
        if cnt == 1:
            print(temp_str, end="")
        else:
            print(temp_str+str(cnt), end="")