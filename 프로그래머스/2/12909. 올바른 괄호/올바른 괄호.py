def solution(s):
    stack = []
    for i in s:
        if i == "(":
            stack.append("(")
        else:
            if not stack:
                return False
            stack.pop()
    
    if not stack:
        return True
    return False