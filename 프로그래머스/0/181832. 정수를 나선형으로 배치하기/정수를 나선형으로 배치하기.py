def solution(n):
    answer = [[0 for i in range(n)] for i in range(n)]        
    if n%2 == 1:
        answer[n//2][n//2] = n**2
        
    value = 1
    for i in range(n//2): # 한바퀴 회전 시작 지점
        x, y = i,i
        # →
        for y in range(i, n-i):
            answer[i][y] = value
            value += 1
        # ↓
        for x in range(i+1, n-i):
            answer[x][y] = value
            value += 1
        # ←    
        for y in range(y-1, i-1, -1): 
            answer[x][y] = value
            value += 1
        # ↑       
        for x in range(x-1, i, -1):
            answer[x][y] = value
            value += 1
    
    return answer