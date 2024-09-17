def solution(strArr):
    answer = []
    for i in strArr:
        if not "ad" in i:
            answer.append(i)
    return answer