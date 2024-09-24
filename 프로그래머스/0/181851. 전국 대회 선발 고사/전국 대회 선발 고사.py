def solution(rank, attendance):
    arr = []
    for i in range(len(rank)):
        idx = rank.index(i+1)
        if attendance[idx]:
            arr.append(idx)
            
        if len(arr) == 3:
            return 10000*arr[0] + 100*arr[1] + arr[2]
