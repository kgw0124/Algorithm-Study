def solution(num_list):
    value1 = "" #짝
    value2 = "" #홀
    
    for i in num_list:
        if i%2 == 0:
            value1 += str(i)
        else:
            value2 += str(i)
    
    answer = int(value1) + int(value2)
    return answer