def solution(num_list):
    total = 0
    for i in num_list:
        while i != 1:
            i //= 2
            total += 1
    return total
            