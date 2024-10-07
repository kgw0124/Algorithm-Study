from collections import deque
import math

def solution(progresses, speeds):
    days = deque([])
    for i in range(len(progresses)):
        day = math.ceil((100 - progresses[i]) / speeds[i])
        days.append(day)
    print(days)
    
    answer = []
    while days:
        front = days.popleft()
        count = 1
        while days and front >= days[0]:
            days.popleft()
            count += 1
        answer.append(count)
    return answer