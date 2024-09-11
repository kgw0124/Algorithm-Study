def solution(arr, query):
    answer = []
    for i in range(len(query)):
        if i == 0:
            answer = arr[:query[i]+1]
        if i%2 == 0:
            answer = answer[:query[i]+1]
        else:
            answer = answer[query[i]:]
    return answer