def solution(arr):
    s = 100000
    e = 0
    for i in range(len(arr)):
        if arr[i] == 2:
            s = min(s,i)
            e = max(e,i)
    
    if s>e:
        return [-1]
    else:
        return arr[s:e+1]