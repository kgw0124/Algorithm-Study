def solution(n, m):
    answer = []
    small = min(n,m)
    for i in range(n,0,-1):
        if n%i==0 and m % i == 0:
            answer.append(i)
            answer.append(i*n/i*m/i)
            return answer
 