def solution(num_list):
    value1 = 1 # 모든 원소들의 곱
    value2 = 0 # 모든 원소들의 합
    for i in num_list:
        value1 *= i
        value2 += i
        
    answer = 0
    if value1 < value2**2:
        answer = 1
    return answer