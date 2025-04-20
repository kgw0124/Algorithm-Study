N,M = map(int, input().split())

# graph 생성
graph = [[] for _ in range(N)]
for i in range(N):
    graph[i] = list(map(int, input().split()))

# DFS
answer = 1e9

def DFS(starty, startx):
    stack = [(starty, startx, 0, 0, graph[starty][startx])]

    while stack:
        y,x,my,mx,val = stack.pop()
        
        for dy, dx in [(1,-1), (1,0), (1,1)]:
            if my==dy and mx==dx:
                continue
            
            if y==N-1: # graph 마지막 줄
                global answer
                answer = min(answer, val)

            ny, nx = y+dy, x+dx
            if 0<=ny<N and 0<=nx<M:
                stack.append((ny,nx,dy,dx,val+graph[ny][nx]))

for x in range(M):
    DFS(0, x)

print(answer)