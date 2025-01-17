import collections

def solution(k, tangerine):
    # (1) dictionary 생성
    dict = collections.Counter(tangerine)
    
    # (2) value 추출 후, 정렬
    # ★★.sort()는 list에만 사용 가능★★
    val = sorted(dict.values(), reverse=True)
    
    # (3) 정답 구하기
    sum = 0
    answer = 0
    for v in val:
        sum += v
        answer += 1
        if sum >= k:
            break
    return answer
    
#     (1) dictionary 생성
#     td = {}
#     for t in tangerine:
#         if t in td.keys():
#             td[t] = td[t] + 1
#         else:
#             td[t] = 1
    
#     ★★ dictionary를 value를 기준으로 내림차순 정렬 ★★
#     sorted_td = dict(sorted(td.items(), key=lambda x: x[1], reverse=True))
    
#     정답 구하기
#     sum = 0
#     answer = 0
#     for t in sorted_td.values():
#         sum += t
#         answer += 1
#         if sum >= k:
#             break
#     return answer