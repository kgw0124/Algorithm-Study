def solution(l, r):
    arr = []
    
    for i in range(l, r+1):
        if not set(str(i)) - {'0', '5'}:
            arr.append(i)
        
    if not arr:
        arr = [-1]
        
    return arr