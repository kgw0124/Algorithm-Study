def solution(n):
    cnt = 1
    for i in range(1, n):
        sum = i
        for j in range(i+1, n):
            sum += j
            if sum < n:
                continue
            elif sum == n:
                cnt += 1
                break
            else:
                break
    return cnt