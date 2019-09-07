def solution(record):
    dict = {}
    lst = []
    for s in record:
        temp = s.split(" ")
        if temp[0] == "Enter":
            dict[temp[1]] = temp[2]
        elif temp[0] == "Change":
            dict[temp[1]] = temp[2]
    
    for s in record:
        temp = s.split(" ")
        if temp[0] == "Enter":
            lst.append(dict[temp[1]] + "님이 들어왔습니다.")
        elif temp[0] == "Leave":
            lst.append(dict[temp[1]] + "님이 나갔습니다.")
    return lst