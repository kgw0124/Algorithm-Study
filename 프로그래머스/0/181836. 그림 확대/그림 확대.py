def solution(picture, k):
    answer = []
    for line in picture:
        for i in range(k): # 세로
            answer.append(line.replace(".", "."*k).replace("x", "x"*k)) # 가로
    return answer