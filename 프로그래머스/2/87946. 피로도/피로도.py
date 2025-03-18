from itertools import permutations

def solution(k, dungeons):
    idx = [i for i in range(len(dungeons))] # [[80,20],[50,40],[30,10]]
    idx_perm = list(permutations(idx)) # [(0, 1, 2), (0, 2, 1), (1, 0, 2), ...]
 
    arr = []
    for p in idx_perm:
        tmp = k
        cnt = 0
        for i in p:
            if tmp >= dungeons[i][0]:
                tmp -= dungeons[i][1]
                cnt += 1
        arr.append(cnt)
        
    return max(arr)
