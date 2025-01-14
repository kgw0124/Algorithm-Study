def solution(people, limit):
    # !! [조건] 보트에 최대 2명 탑승 가능
    people.sort()
    
    # pop()으로 min, max 삭제 > 시간 초과
    cnt = 0
    maxIdx = len(people) - 1
    minIdx = 0
    while minIdx <= maxIdx:
        cnt += 1
        if people[minIdx] + people[maxIdx] <= limit:
            minIdx += 1
            maxIdx -= 1
        else:
            maxIdx -= 1
            
    return cnt