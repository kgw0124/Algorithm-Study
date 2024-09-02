def solution(code):
    ret = ''
    mode = 0
    
    for i in range(0, len(code)):
        if mode == 0:
            if code[i] == '1':
                mode = 1
            elif i%2 == 0:
                ret += code[i]
        else: # mode == 1
            if code[i] == '1':
                mode = 0
            elif i%2 == 1:
                ret += code[i]
                
    answer = ret
    if ret == "":
        answer = "EMPTY"
    return answer