def solution(my_string, m, c):
    i = 1
    answer = ''
    while c+(i-1)*m-1 < len(my_string):
        answer += my_string[c+(i-1)*m-1]
        i+=1

    return answer