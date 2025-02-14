from collections import deque

# DFS
def DFS(graph, checker, start, answer):
    checker[start] = True
    answer.append(str(start))
    
    for end in graph[start]:
        if not checker[end]:
            DFS(graph, checker, end, answer)

# BFS
def BFS(graph, checker, start, answer):
    queue = deque([start])
    checker[start] = True
    answer.append(str(start))

    while queue:
        start = queue.popleft()
        for end in graph[start]:
            if not checker[end]:
                queue.append(end)
                checker[end] = True
                answer.append(str(end))

# main
N, M, V = map(int, input().split())

# graph 생성
graph = [[] for _ in range(N+1)]
for _ in range(M):
    start, end = map(int, input().split())
    # (조건 2) 양방향 graph
    graph[start].append(end)
    graph[end].append(start)

# (조건 1) start에서 방문할 수 있는 end가 여러 개일 경우, 작은 것부터 방문
for i in range(1, N + 1):
    graph[i].sort()

# DFS 수행
checker = [False for _ in range(N+1)]
answer = []
DFS(graph, checker, V, answer)
print(' '.join(answer))

# BFS 수행
checker = [False for _ in range(N+1)]
answer = []
BFS(graph, checker, V, answer)
print(' '.join(answer))

