N, score, P = map(int, input().split())

if N:
    arr = list(map(int, input().split()))
    arr.append(score)
    arr.sort(reverse=True)
    
    rank = arr.index(score) + 1
    if rank > P:
        print(-1)
    else:
        if N==P and score <= arr[-1]:
            print(-1)
        else:
            print(rank)
else:
    print(1)