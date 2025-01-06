def solution(s):
    answer = [0, 0]
    
    while s != '1':
        answer[0] += 1
        
        # 1. 모든 0 제거
        temp = len(s)
        s= s.replace('0', '')
        answer[1] += temp - len(s)
        
        # 2. 이진 변환2. 이진 변환
        s = bin(len(s))[2:]

    return answer