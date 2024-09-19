def solution(prev):
    count = 0
    new = [i for i in prev]
    
    while True:
        count += 1
        for i in range(len(prev)):
            if prev[i]>=50 and prev[i]%2==0:
                new[i] = prev[i]/2
            elif prev[i]<50 and prev[i]%2==1:
                new[i] = prev[i]*2 +1
                
        if prev == new:
            break
        else:
            prev = [i for i in new]

    return count-1