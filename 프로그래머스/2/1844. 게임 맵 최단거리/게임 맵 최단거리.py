from collections import deque
def BFS(maps,n,m):
    queue = deque()
    queue.append((0,0,1))
    maps[0][0] = -1 # 방문 처리
    
    while queue:
        x,y,cnt = queue.popleft()
        
        for dx, dy in [(-1,0), (1,0), (0,-1), (0,1)]: # 상하좌우
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<m and maps[nx][ny]==1:
                if nx==n-1 and ny==m-1:
                    return cnt+1
                else:
                    queue.append((nx,ny,cnt+1))
                    maps[nx][ny] = -1 # 방문 처리
    return -1

def solution(maps):
    n,m = len(maps), len(maps[0])
    return BFS(maps, n, m)