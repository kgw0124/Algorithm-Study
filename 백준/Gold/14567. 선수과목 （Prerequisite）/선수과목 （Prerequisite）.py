import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())

# graph, inDegree 생성
graph = [[] for _ in range(N+1)]
inDegree = [0 for _ in range(N+1)]
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    inDegree[B] += 1

# 진입 차수가 0인 node를 queue에 저장
queue = deque()
for idx, val in enumerate(inDegree):
    if idx > 0 and val == 0:
        queue.append(idx)

# 간선 제거
answer = [1 for _ in range(N+1)]
while queue:
    tmp = queue.popleft()

    for next in graph[tmp]:
        inDegree[next] -= 1 # tmp와 next 사이의 간선 제거
        answer[next] = answer[tmp] + 1

        if inDegree[next] == 0:
            queue.append(next)

for a in answer[1:]:
    print(a, end=" ")