def solution(N, stages):
    sg = []
    l = len(stages)
    for i in range(1, N+1):
        # 1~ 번째 스테이지에 도달한것 카운트
        h_count = stages.count(i)
        if l == 0:
            sg.append((i, 0))
        else:
            sg.append((i, h_count / l))
        l = l - h_count
    sg = sorted(sg, key = lambda x : x[1], reverse=True)
    sg = [x[0] for x in sg]
    return sg