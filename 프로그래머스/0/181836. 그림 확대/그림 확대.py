def solution(picture, k):
    answer = []
    for line in picture:
        newLine = ""
        for i in line: # 가로
            newLine += i*k
        for j in range(k): # 세로
            answer.append(newLine)
    return answer