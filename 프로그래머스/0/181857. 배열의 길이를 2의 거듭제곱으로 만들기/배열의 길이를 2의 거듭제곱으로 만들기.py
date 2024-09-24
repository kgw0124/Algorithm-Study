def solution(arr):
    while True:
        for i in range(11):
            if len(arr) == 2**i:
                return arr
        arr.append(0)