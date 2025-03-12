from collections import deque

T = int(input())

answer = []
for i in range(T):
    func = input()
    size = int(input())
    queue = deque(input()[1:-1].split(','))
    
    if size == 0:
        queue = deque()

    flag = 0
    isBreak = False
    for f in func:
        if f == "R":
            flag += 1
        elif f == "D":
            if not queue:
                answer.append('error')
                isBreak = True
                break
            else:
                if flag % 2 == 0:
                    queue.popleft()
                    flag = 0
                else:
                    queue.pop()

    if isBreak:
        continue

    if flag % 2 == 1:
        queue.reverse()

    answer.append("[" + ','.join(queue) + "]")

for a in answer:
    print(a)