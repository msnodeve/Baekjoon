def dfs(numbers, target, index, value):
    # 해당 index가 주어진 배열의 끝일 경우
    if index == len(numbers):
        # 주어진 target 값과 계산한 value 값이 같을 경우 방법 1반환, 아닐 경우 0 반환
        return int((target == value) == True)
    else:
        # (+ 경우) + (- 경우)
        return dfs(numbers, target, index + 1, value + numbers[index]) + dfs(numbers, target, index + 1, value - numbers[index])
        
def solution(numbers, target):
    # index와 value를 0으로 초기화 후 처음부터 깊이 탐색 시작
    index, value = 0, 0
    # dfs 검색할 경우 아래에서부터 target에 맞는 경로 1을 반환하여 더해주고, 반환
    return dfs(numbers, target, index, value)