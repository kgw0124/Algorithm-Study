def solution(str1, str2):
    length = len(str1)
    
    answer = ''
    for i in range(length):
        answer += str1[i] + str2[i]

    return answer