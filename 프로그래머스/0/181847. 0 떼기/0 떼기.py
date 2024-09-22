def solution(n_str):
    for i in range(len(n_str)):
        if n_str[0] == "0":
            n_str = n_str[1:]
        else:
            break
    return n_str