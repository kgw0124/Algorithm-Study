def solution(n):
    answer = 0
    
    if n%2 == 1: #홀수
        for i in range(1,n+1,2):
            answer += i
        
    else: #짝수
        for i in range(0,n+1,2):
            answer += i*i
            
    return answer