def solution(k, tangerine):
    # dictionary 생성
    td = {}
    for t in tangerine:
        if t in td.keys():
            td[t] = td[t] + 1
        else:
            td[t] = 1
    
    # ★★ dictionary를 value를 기준으로 내림차순 정렬 ★★
    sorted_td = dict(sorted(td.items(), key=lambda x: x[1], reverse=True))
    
    #
    sum = 0
    answer = 0
    for t in sorted_td.values():
        sum += t
        answer += 1
        if sum >= k:
            break
    return answer