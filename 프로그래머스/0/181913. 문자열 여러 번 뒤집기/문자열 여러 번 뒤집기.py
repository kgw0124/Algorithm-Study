def solution(my_string, queries):
    to_list = list(my_string)
    for s, e in queries:
        while e-s>=1:
            to_list[s], to_list[e] = to_list[e], to_list[s]
            s+=1
            e-=1

    return "".join(to_list)