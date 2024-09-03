def solution(num_list):
    value1 = num_list[len(num_list)-1] # 마지막 원소
    value2 = num_list[len(num_list)-2] # 마지막 원소 그전 원소
    
    if value1 > value2:
        num_list.append(value1 - value2)
    else:
        num_list.append(value1*2)
        
    return num_list