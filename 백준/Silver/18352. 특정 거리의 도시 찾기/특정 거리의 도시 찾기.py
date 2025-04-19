import sys
from collections import deque

input = sys.stdin.readline

N, M, K, X = map(int, input().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)

# BFS
answer = []
def BFS(start):
    checker = [0 for _ in range(N+1)]
    queue = deque([(start, 0)])
    checker[start] = 1

    while queue:
        now, dist = queue.popleft()
        
        if dist == K:
            answer.append(now)
            continue

        for next  in graph[now]:
            if checker[next] == 0:
                queue.append((next, dist+1))
                checker[next] = 1

BFS(X)

# 정답
if len(answer) == 0:
    print(-1)
else:
    for a in sorted(answer):
        print(a)