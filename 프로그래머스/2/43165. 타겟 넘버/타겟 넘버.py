def solution(numbers, target):
    answer = 0
    
    stack = [(0,0)]
    while stack:
        idx, total = stack.pop()
        if idx == len(numbers):
            if total == target:
                answer += 1
            continue
        
        stack.append((idx+1, total+numbers[idx]))
        stack.append((idx+1, total-numbers[idx]))
    
#     def DFS(idx, total):
#         nonlocal answer
#         if idx == len(numbers):
#             if total == target:
#                 answer += 1
#             return
        
#         DFS(idx+1, total+numbers[idx])
#         DFS(idx+1, total-numbers[idx])
    
#     DFS(0,0)
    
    return answer
