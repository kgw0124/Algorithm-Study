def solution(s):
    answer = 0
    
    for i in range(len(s)):
        # 회전
        newS = s[i:] + s[:i]
        
        # 올바른 괄호 문자열 확인
        myMap = { "]": "[", ")": "(", "}": "{" }
        stack = []
        for w in newS:
            if not stack or w not in myMap.keys():
                stack.append(w)
            else:
                if myMap[w] == stack[-1]:
                    stack.pop()
                else:
                    stack.append(w)
        if not stack:
            answer += 1

    return answer