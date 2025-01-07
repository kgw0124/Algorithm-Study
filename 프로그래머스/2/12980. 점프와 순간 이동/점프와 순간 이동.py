def solution(n):
    answer = 0
    while n > 0:
        if n % 2 == 0:
            n = n // 2 # 순간이동
        else:
            n = n - 1 # 점프
            answer += 1
    
    return answer