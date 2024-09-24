def solution(a, b):
    val1 = a%2
    val2 = b%2
    
    if val1 and val2:
        return a**2 + b**2
    elif not val1 and not val2:
        return abs(a-b)
    else:
        return 2*(a+b)