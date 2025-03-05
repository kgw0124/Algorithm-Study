# BFS
from collections import deque

def BFS(start, end):
    answer = 0
    checker = [0 for _ in range(100001)]

    queue = deque([start, 100001])
    checker[start] = 1

    while queue:
        init = queue.popleft()

        if init == end:
            return answer

        if init == 100001:
            queue.append(100001)
            answer += 1
            continue

        for dx in [-1, 1, init]:
            nx = init + dx
            if 0 <= nx <= 100000 and checker[nx] == 0:
                queue.append(nx)
                checker[nx] = 1
                
# Main
N, K = map(int, input().split())
print(BFS(N,K))

