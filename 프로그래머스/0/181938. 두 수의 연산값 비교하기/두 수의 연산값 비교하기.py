def solution(a, b):
    value1 = int(str(a) + str(b))
    value2 = 2*a*b
    answer = max(value1, value2)
    return answer