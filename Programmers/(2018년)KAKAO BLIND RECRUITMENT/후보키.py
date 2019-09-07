from itertools import chain, combinations

def get_all_subset(iterable):
    s = list(iterable)
    return chain.from_iterable(combinations(s, r) for r in range(len(s) + 1))

def solution(relation):
    subset_list = get_all_subset(list(range(0, len(relation[0]))))
    lst = []
    for i in subset_list:
        n = True
        row_set = set()
        for x in range(len(relation)):
            temp = ' '
            for j in i:
                temp += relation[x][j] + '.'
            if temp in row_set:
                n = False
                break
            row_set.add(temp)
        if n:
            lst.append(i)
    result = []
    for i in lst:
        i = set(i)
        c = True
        for j in result:
            if j.issubset(i):
                c = False
        if c:
            result.append(i) 
    return len(result)