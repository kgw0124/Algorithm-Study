answer = 0

# BFS
from collections import deque

def BFS(graph, idx1, idx2, N, M):
    global answer
    queue = deque()
    queue.append((idx1, idx2))
    graph[idx1][idx2] = "VISIT"

    while queue:
        tmp1, tmp2 = queue.pop()

        for dx, dy in [(1,0), (0,1), (-1,0), (0,-1)]:
            nx, ny = tmp1 + dx, tmp2 + dy
            if 0<=nx<N and 0<=ny<M and (graph[nx][ny] == "O" or graph[nx][ny] == "P"):
                if graph[nx][ny] == "P":
                    answer += 1
                queue.append((nx, ny))
                graph[nx][ny] = "VISIT"

# Main
N, M = map(int, input().split())

idx1, idx2 = 0,0
graph = [[] for _ in range(N)]
for i in range(N):
    tmp = input()
    for j in range(M):
        if tmp[j] == "I":
            idx1, idx2 = i,j
        graph[i].append(tmp[j])

BFS(graph, idx1, idx2, N, M)

if answer == 0:
    answer = "TT"
print(answer)