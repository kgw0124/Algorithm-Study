def solution(number, k):
    stack = []
    
    for idx, v in enumerate(number):
        if not stack:
            stack.append(v)
        else:
            if (stack[-1] < v):
                while(stack and k>0 and stack[-1] < v):
                    stack.pop(-1)
                    k -= 1
            stack.append(v)

    for i in range(k):
	    stack.pop(-1)

    return ''.join(stack)