# DFS
from collections import deque

def BFS(start, end):
    checker, dist = [0 for _ in range(100001)], [0 for _ in range(100001)]

    queue = deque([start])
    checker[start] = 1

    while queue:
        init = queue.popleft()

        if init == end:
            return dist[init]

        for dx in [-1, 1, init]:
            nx = init + dx
            if 0 <= nx <= 100000 and checker[nx] == 0:
                queue.append(nx)
                checker[nx] = 1
                dist[nx] = dist[init] + 1
                
# Main
N, K = map(int, input().split())
print(BFS(N,K))

