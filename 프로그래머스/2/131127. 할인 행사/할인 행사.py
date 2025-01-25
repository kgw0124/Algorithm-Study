def solution(want, number, discount):
    wish = {}
    for idx, val in enumerate(want):
        wish[val] = number[idx]
            
    answer = 0
    for i in range(0, len(discount)-9):
        sale = discount[i: i+10]
        
        isPass = True
        for k in wish.keys():
            if sale.count(k) != wish[k]:
                isPass = False
                break
        
        if isPass:
            answer += 1
        
    return answer