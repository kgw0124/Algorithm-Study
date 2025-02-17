# DFS
cnt = 0

def DFS(graph, checker, start):
    checker[start] = True

    for next in graph[start]:
        if not checker[next]:
            global cnt
            cnt += 1
            DFS(graph, checker, next)

# main
n = int(input())
m = int(input())

graph = [[] for i in range(n+1)]
for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)
checker = [False for i in range(n+1)]

DFS(graph, checker, 1)

print(cnt)