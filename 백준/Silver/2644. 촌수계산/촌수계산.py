# BFS
from collections import deque
def BFS(graph, checker, start, end):
    queue = deque([(start, 0)]) # (노드명, 촌수)
    checker[start] = True

    while queue:
        start, cnt = queue.popleft() # (시작 노드명, 현재 촌수)
        if start == end:
            return cnt

        for next in graph[start]:
            if not checker[next]:
                queue.append((next, cnt+1)) # (다음 노드명, 현재 촌수+1)
                checker[next] = True
    
    return -1


# main
n = int(input())
start, end = map(int, input().split())
m = int(input())

graph = [[] for _ in range(n+1)]
for i in range(m):
    x, y = map(int, input().split())
    # 양방향 graph
    graph[x].append(y)
    graph[y].append(x)

checker = [False for _ in range(n+1)]

print(BFS(graph, checker, start, end))