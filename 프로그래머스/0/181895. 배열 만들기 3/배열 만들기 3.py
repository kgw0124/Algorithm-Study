def solution(arr, intervals):
    answer = []
    for s,e in intervals:
        for i in arr[s:e+1]:
            answer.append(i)
    return answer