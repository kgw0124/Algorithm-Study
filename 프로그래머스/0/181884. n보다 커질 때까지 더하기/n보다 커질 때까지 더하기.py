def solution(numbers, n):
    i = 0
    answer = 0
    while answer <= n:
        answer += numbers[i]
        i += 1
    return answer