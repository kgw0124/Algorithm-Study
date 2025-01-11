def solution(n):
    n1 = bin(n)[2:].count('1')
    
    temp = n + 1
    while True:
        if bin(temp)[2:].count('1') == n1:
            return temp
        temp += 1