def solution(a, b, c):
    answer = 0
    if a!=b and b!=c and c!=a: # 세 숫자가 모두 다른 경우
        answer = a+b+c
    elif a==b==c: # 세 숫자가 모두 같은 경우
        answer = (a+b+c) * (a**2 + b**2 + c**2) * (a**3 + b**3 + c**3)
    else: # 세 숫자 중 두 숫자만 같은 경우
        answer = (a+b+c) * (a**2 + b**2 + c**2)

    return answer