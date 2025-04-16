answer = []

for _ in range(int(input())):
    tmp = 0
    M, N, K = map(int, input().split())
    
    graph = [[0 for _ in range(M)] for _ in range(N)]
    for _ in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1

    for y in range(N):
        for x in range(M):
            if graph[y][x] == 1:
                tmp += 1                         
                
                # dfs
                stack = [(y,x)]
                while stack:
                    ty, tx = stack.pop()
                    graph[ty][tx] = -1
                    
                    for dy, dx in [(1,0), (-1,0), (0,1), (0,-1)]:
                        ny, nx = ty + dy, tx + dx
                        if 0 <= ny < N and 0 <= nx < M and graph[ny][nx] == 1:
                            stack.append((ny, nx))

    answer.append(tmp)

for a in answer:
    print(a)