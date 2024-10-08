from collections import deque

def solution(priorities, location):
    v = max(priorities)
    q = deque([])
    for i in range(len(priorities)):
        q.append((priorities[i], i))
     
    answer = 0
    while q:
        temp = q.popleft()
        
        if temp[0] < v:
            q.append(temp)
            
        elif temp[0] == v:            
            answer += 1
            if temp[1] == location:
                return answer
            
            if len(priorities) > 1:
                priorities.remove(v)
                v = max(priorities)