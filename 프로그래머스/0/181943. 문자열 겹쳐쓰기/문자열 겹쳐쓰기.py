def solution(my_string, overwrite_string, s):
    
    e = s + len(overwrite_string)
        
    answer = f'{my_string[:s]}{overwrite_string}{my_string[e:]}'
    return answer