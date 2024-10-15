def solution(sizes):
    # width가 항상 height보다 길다고 가정
    max_width = 0
    max_height = 0
    
    for w,h in sizes:        
        max_width = max(max_width, max(w,h))
        max_height = max(max_height, min(w,h))
        
    return max_width * max_height