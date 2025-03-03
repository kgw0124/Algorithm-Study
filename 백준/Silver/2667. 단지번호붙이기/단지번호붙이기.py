# DFS
def DFS(graph, i, j, n):
    graph[i][j] = -1
    cnt = 1

    # 상하좌우 탐색
    for di, dj in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
        ni, nj = i + di, j + dj
        if 0 <= ni < n and 0 <= nj < n and graph[ni][nj] == 1:
            cnt += DFS(graph, ni, nj, n)

    return cnt

    
# main
n = int(input())
graph = []
for i in range(n):
    graph.append([int(i) for i in input()])

answer = []
for i in range(n): # 행
    for j in range(n): # 열
        if graph[i][j] == 1:
            answer.append(DFS(graph, i, j, n))

answer.sort()
print(len(answer))
for a in answer:
    print(a)