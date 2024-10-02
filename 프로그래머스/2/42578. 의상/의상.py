def solution(clothes):
    dictionary = {}
    
    for name, kind in clothes:
        dictionary[kind] = dictionary.get(kind, [])
        dictionary[kind].append(name)
    
    answer = 1
    for kind in dictionary.keys():
        answer *= len(dictionary[kind])+1 # 1을 더하지 않는 이유? 아무것도 선택하지 않는 경우 고려
    
    return answer - 1 # 1을 빼는 이유? 모두 선택하지 않는 경우 제거