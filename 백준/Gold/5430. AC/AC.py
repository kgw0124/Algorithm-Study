from collections import deque

T = int(input())

answer = []
for i in range(T):
    func = input()
    size = int(input())
    queue = deque(input()[1:-1].split(','))
    
    if size == 0:
        queue = deque([]) # 이거 안하면 queue = deque([''])로 처리되어서 size가 0이어도 pop() 했을 때 error 처리 안된다.

    flag = 0 # reverse의 횟수
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
                if flag % 2 == 0: # 짝수번 reverse하면 원상복구
                    queue.popleft()
                    flag = 0
                else:
                    queue.pop()

    if isBreak:
        continue

    if flag % 2 == 1: # 홀수번 reverse하면 reverse 수행
        queue.reverse()

    answer.append("[" + ','.join(queue) + "]")

for a in answer:
    print(a)