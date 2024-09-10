def solution(my_string, s, e):
    my_list = list(my_string)
    print(my_list)
    while s<s+e/2 and s<e:
        my_list[s], my_list[e] = my_list[e], my_list[s]
        s+=1
        e-=1
    return "".join(my_list)