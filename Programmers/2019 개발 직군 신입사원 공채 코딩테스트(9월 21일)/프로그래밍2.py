import queue

q = queue.Queue()

def check(x, y, R, C):
    return x >= 0 and x < R and y >= 0 and y <= C

def solution(drum);
    R = len(drum[0])
    C = len(drum)

    result = 0

    for i in range(R):
        while q.qsize() != 0:
            q.get()
        q.put([0,i])
        starCount = 0

        while q.qsize() != 0:
            x, y = q.get()

            if x >= R:
                result += 1
                break
            
            if check(x, y, R, C) == False:
                break

            if drum[x][y] == '#':
                x, y = x + 1, y
            elif drum[x][y] == '>':
                x, y = x, y + 1
            elif drum[x][y] == '<':
                x, y = x, y - 1
            elif drum[x][y] == '*':
                x, y = x + 1, y
                starCount += 1

            if starCount >= 2:
                break
            
            q.put([x, y])
            
    return result