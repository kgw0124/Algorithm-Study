def solution(num_list):
    total = 0
    for i in num_list:
        count = 0
        while i != 1:
            if i%2 == 0:
                i /= 2
                count += 1
            else:
                i = (i-1)/2
                count += 1
        total += count
    return total
            