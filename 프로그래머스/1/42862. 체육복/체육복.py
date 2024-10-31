def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    
    for l in lost[:]: # 제한사항 5 
        if l in reserve:
            lost.remove(l)
            reserve.remove(l)
            
    for l in lost[:]:
        if (l-1) in reserve:
            lost.remove(l)
            reserve.remove(l-1)
            continue
        if (l+1) in reserve:
            lost.remove(l)
            reserve.remove(l+1)

    return n - len(lost)