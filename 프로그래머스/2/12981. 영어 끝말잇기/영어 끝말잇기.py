def solution(n, words):
    for idx, w in enumerate(words):
        
        if idx > 0 and (w in words[:idx] or w[0] != words[idx-1][-1]):
            return [idx%n+1, idx//n+1]
            
    return [0,0]
    