def solution(a, b):
    value1 = str(a) + str(b)
    value2 = str(b) + str(a)
    answer = int(max(value1, value2))
    return answer